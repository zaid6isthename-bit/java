const fs = require("node:fs");
const path = require("node:path");
const yauzl = require("yauzl");

const projectRoot = path.join(__dirname, "..");
const sourceDir = path.join(projectRoot, "java-experiments");
const zipFile = path.join(projectRoot, "public", "Java-Experiments.zip");
const zipPrefix = "Java-Experiments/";

function collectFiles(dir, base) {
  const results = [];
  for (const entry of fs.readdirSync(dir, { withFileTypes: true })) {
    if (entry.name === ".env" || entry.name === "node_modules" || entry.name === ".git") continue;
    const full = path.join(dir, entry.name);
    const rel = path.join(base, entry.name).replace(/\\/g, "/");
    if (entry.isDirectory()) results.push(...collectFiles(full, rel));
    else results.push(rel);
  }
  return results;
}

function readZipEntries(zipFile) {
  return new Promise((resolve, reject) => {
    yauzl.open(zipFile, { lazyEntries: true }, (err, zipfile) => {
      if (err) return reject(err);
      const entries = [];
      zipfile.on("entry", (entry) => {
        if (!/\/$/.test(entry.fileName)) entries.push(entry.fileName);
        zipfile.readEntry();
      });
      zipfile.on("end", () => resolve(entries));
      zipfile.on("error", reject);
      zipfile.readEntry();
    });
  });
}

async function main() {
  const checks = [];
  const sourceFiles = collectFiles(sourceDir, "Java-Experiments").sort();
  const zipEntries = (await readZipEntries(zipFile)).sort();

  checks.push(["java-experiments/ exists", fs.existsSync(sourceDir)]);
  checks.push(["public/Java-Experiments.zip exists", fs.existsSync(zipFile)]);
  checks.push(["ZIP is not empty", zipEntries.length > 0]);
  checks.push(["ZIP entries match source files exactly", JSON.stringify(zipEntries) === JSON.stringify(sourceFiles)]);
  checks.push(["Nested folder structure preserved", zipEntries.some((e) => e.includes("/"))]);
  checks.push(["ZIP has no .env", !zipEntries.some((e) => e.includes(".env"))]);
  checks.push(["ZIP has no node_modules", !zipEntries.some((e) => e.includes("node_modules"))]);
  checks.push(["ZIP has no .git", !zipEntries.some((e) => e.includes(".git"))]);

  let failed = false;
  for (const [name, ok] of checks) {
    console.log(`${ok ? "PASS" : "FAIL"}  ${name}`);
    if (!ok) failed = true;
  }

  if (sourceFiles.length !== zipEntries.length) {
    console.log("\nExpected entries:");
    console.log(sourceFiles.join("\n"));
    console.log("\nActual ZIP entries:");
    console.log(zipEntries.join("\n"));
  }

  if (failed) process.exit(1);
  console.log(`\nAll checks passed. ${zipEntries.length} file(s) in the ZIP.`);
}

main().catch((err) => {
  console.error("Verification failed:", err.message);
  process.exit(1);
});