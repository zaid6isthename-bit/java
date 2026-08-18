import { NextResponse } from "next/server";
import { readFile } from "node:fs/promises";
import path from "node:path";

export async function GET() {
  const zipPath = path.join(process.cwd(), "public", "Java-Experiments.zip");

  let data: Buffer;
  try {
    data = await readFile(zipPath);
  } catch {
    return new NextResponse("Java-Experiments.zip not found.", { status: 404 });
  }

  return new NextResponse(new Uint8Array(data), {
    headers: {
      "Content-Type": "application/zip",
      "Content-Disposition": 'attachment; filename="Java-Experiments.zip"',
      "Content-Length": String(data.length),
    },
  });
}