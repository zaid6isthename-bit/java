# Java Experiments Downloader

Open one URL and the browser immediately downloads all your Java experiment folders as a single ZIP.

```
java-experiments/
        |
        v
  build script (create-zip.js)
        |
        v
  public/Java-Experiments.zip
        |
        v
      Vercel
        |
        v
  GET /  ->  Java-Experiments.zip download
```

## Add Java experiments

Put your experiment folders inside `java-experiments/`:

```
java-experiments/
├── Experiment-1/
│   └── Main.java
├── Experiment-2/
│   └── Main.java
└── Experiment-3/
    └── Main.java
```

Everything inside `java-experiments/` is automatically included in the ZIP. Nested folders are preserved. No configuration file to update. Delete a folder and it disappears from the next ZIP.

## Run locally

```bash
npm install
npm run build
npm run start
```

Then open `http://localhost:3000/` and the browser downloads `Java-Experiments.zip`.

To check the ZIP contents:

```bash
npm run verify
```

## Deploy to Vercel

1. Push this project to a GitHub repository.
2. Go to [vercel.com](https://vercel.com) and click **Add New > Project**.
3. Import the repository (framework is auto-detected as Next.js).
4. Click **Deploy**. The build automatically creates the ZIP.
5. Done.

## Usage

Open the deployed URL, e.g.:

```
https://YOUR-PROJECT.vercel.app/
```

The browser immediately downloads:

```
Java-Experiments.zip
```

No buttons, no forms, no login. The URL itself is the downloader.

Optional health check: `https://YOUR-PROJECT.vercel.app/health` returns `{"status":"ok"}`.