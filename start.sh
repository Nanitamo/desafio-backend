docker-compose down

#build backend image
docker build -t backend-pagnet:latest ./backend

#build frontend image
docker build -t frontend-pagnet:latest ./frontend

#start envoironment
docker-compose up --build --force-recreate --remove-orphans