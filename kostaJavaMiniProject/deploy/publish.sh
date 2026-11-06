#!/usr/bin/env bash
# github.io 저장소에 배포 파일을 모은다 (커밋/푸시는 하지 않음)
#   billim/         ← React 화면 (GitHub Pages, https://yusin-bit.github.io/billim/)
#   billim-server/  ← Java 서버 소스 + Dockerfile (Render 가 이 폴더로 빌드)
# 사용법: bash deploy/publish.sh [github.io 저장소 경로]
set -euo pipefail

PROJECT="$(cd "$(dirname "$0")/.." && pwd)"
SITE="${1:-$HOME/Documents/yusin-bit.github.io}"

[ -d "$SITE/.git" ] || { echo "github.io 저장소를 찾을 수 없습니다: $SITE"; exit 1; }

echo "1) React 화면 빌드 (Pages 모드)"
(cd "$PROJECT/frontend" && npm run build:pages)

echo "2) billim/ 교체"
rm -rf "$SITE/billim"
cp -r "$PROJECT/frontend/dist-pages" "$SITE/billim"

echo "3) billim-server/ 교체 (src + Dockerfile + MySQL 드라이버, DB 설정 파일은 포함하지 않음)"
rm -rf "$SITE/billim-server"
mkdir -p "$SITE/billim-server"
cp "$PROJECT/deploy/server/Dockerfile" "$PROJECT/deploy/server/.dockerignore" "$PROJECT/deploy/server/README.md" "$SITE/billim-server/"
cp -r "$PROJECT/src" "$SITE/billim-server/src"
cp -r "$PROJECT/deploy/server/lib" "$SITE/billim-server/lib"   # MySQL 드라이버 (빌드 때 인터넷에서 받지 않음)

echo "완료: $SITE"
(cd "$SITE" && git status --short | head -20)
