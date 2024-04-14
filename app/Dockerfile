FROM docker.io/library/node:21-alpine3.18 AS BUILDER

WORKDIR /app

COPY package.json ./
COPY package-lock.json ./
COPY src/ ./
COPY tsconfig.json ./

RUN npm ci
RUN npm run build

FROM docker.io/library/node:21-alpine3.18 AS RUNNER

EXPOSE 3000

WORKDIR /app

COPY package.json ./
COPY package-lock.json ./
COPY --from=BUILDER /app/dist ./

RUN npm ci --omit=dev

CMD [ "node", "/app/app.js" ]