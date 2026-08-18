const archiver = require("archiver");
const fs = require("node:fs");
const path = require("node:path");

const projectRoot = path.join(__dirname, "..");
const sourceDir = path.join(projectRoot, "java-experiments");
const outDir = path.join(projectRoot, "public");
const outFile = path.join(outDir, "Java-Experiments.zip");

if (!fs.existsSync(sourceDir)) {
  console.error("java-experiments directory not found.");
  console.error(
    "Please create the java-experiments directory and place your Java experiment folders inside it."
  );
  process.exit(1);
}

fs.mkdirSync(outDir, { recursive: true });

const output = fs.createWriteStream(outFile);
const archive = archiver("zip", { zlib: { level: 9 } });

archive.on("warning", (err) => {
  console.warn("ZIP warning:", err.message);
});

archive.on("error", (err) => {
  console.error("Failed to create ZIP:", err.message);
  process.exit(1);
});

output.on("close", () => {
  console.log(`Created ${path.relative(projectRoot, outFile)} (${archive.pointer()} bytes)`);
});

archive.pipe(output);
archive.directory(sourceDir, "Java-Experiments");
archive.finalize();