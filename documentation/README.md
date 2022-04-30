# Wissenschaftliches Dokumentieren

## Anforderungen
- LaTeX-Installation
- biber (für Literaturverzeichnis)

## Dokument erzeugen
1. `pdflatex main`
2. `biber main`
3. `pdflatex main`
4. `pdflatex main`

## Verwenden in VSCode
1. Einstellungen öffnen
2. Einstellungen zu tools für LaTeX finden
3. biblatex tool kopieren und zu biber umbennenen und Befehl zu biber ändern
4. Recipe mit pdflatex -> biblatex -> pdflatex (2x) kopieren und biblatex zu biber ändern