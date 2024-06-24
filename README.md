# Geo-Locator

Geo-Locator é um serviço inovador que permite a gestão e a localização de pontos de interesse. Utilizando Quarkus, o framework Java supersônico, o Geo-Locator oferece performance e simplicidade no desenvolvimento de APIs RESTful.

## Tecnologias Utilizadas
<img src="https://marcoantdeveloper.netlify.app/assets/img/icons/JAVA.png" width="100px"> <img src="https://marcoantdeveloper.netlify.app/assets/img/icons/QUARKUS.png" width="100px"> <img src="https://marcoantdeveloper.netlify.app/assets/img/icons/DOCKERZADA.png" width="100px"> <img src="https://marcoantdeveloper.netlify.app/assets/img/icons/POSTGRESQL.png" width="100px">

---


### Pré-requisitos

- Docker instalado na máquina
- Maven instalado na máquina
- Java 17 ou superior


___

### Inicie o Docker

1. **Inicie o serviço do banco de dados**
```shell script
> docker compose up -d
```

___

### Inicie o Quarkus 

Para iniciar a aplicação basta rodar o comando:
```shell script
> mvn quarkus:dev
```
<img src="https://i.ibb.co/yRyrghC/image.png">

> **_NOTE:_**  Aplicação pronta para ultilização rodando na porta http://localhost:8085.


___
### Inicie os Testes
Para iniciar os testes da aplicação basta rodar o comando:
```shell script
> mvn quarkus:test
```

<img src="https://i.ibb.co/LCrcQg7/image.png">

> **_NOTE:_**  Com esse comando a aplicação roda os testes unitários e de integração no terminal, mas o vscode também pode rodar os testes.

- Existe uma outra possibilidade de rodar os testes e pode ser acessada via url
```shell script
> http://localhost:8085/q/dev-ui/continuous-testing
```
<img src="https://i.ibb.co/p0JStzY/image.png">

___

### Endpoints | Swagger
- Para acessar o swagger basta iniciar a aplicação e acessar a url:
```shell script
> http://localhost:8085/q/dev-ui/io.quarkus.quarkus-smallrye-openapi/swagger-ui 
```
<img src="https://i.ibb.co/Cm1S04q/image.png">

___

### Regra de Negócio
#### 1. Serviço para cadastrar pontos de interesse

- [x]  **Criar a entidade PointOfInterest:**
    - [x]  Definir atributos: `nome`, `coordenadaX`, `coordenadaY` (inteiros não negativos).
    - [x]  Garantir que os valores de `coordenadaX` e `coordenadaY` sejam não negativos.
- [x]  **Criar o repositório PointOfInterestRepository:**
    - [x]  Implementar os métodos para salvar e recuperar dados do banco de dados.
- [x]  **Implementar o endpoint de cadastro:**
    - [x]  Criar o endpoint `POST /points-of-interest`.
    - [x]  Validar a entrada para garantir que `coordenadaX` e `coordenadaY` sejam não negativos.
    - [x]  Persistir os dados no banco de dados usando o repositório.

#### 2. Serviço para listar todos os POIs cadastrados

- [x]  **Implementar o endpoint de listagem:**
    - [x]  Criar o endpoint `GET /points-of-interest`.
    - [x]  Recuperar todos os POIs do banco de dados usando o repositório.
    - [x]  Retornar a lista de POIs no formato JSON.

#### 3. Serviço para listar POIs por proximidade

- [x]  **Implementar a lógica de proximidade:**
    - [x]  Criar um método para calcular a distância entre dois pontos `(x1, y1)` e `(x2, y2)` usando a fórmula da distância Euclidiana: `sqrt((x2 - x1)^2 + (y2 - y1)^2)`.
- [x]  **Implementar o endpoint de proximidade:**
    - [x]  Criar o endpoint `GET /points-of-interest/proximity`.
    - [x]  Receber parâmetros `x`, `y` e `d-max` na solicitação.
    - [x]  Recuperar todos os POIs do banco de dados usando o repositório.
    - [x]  Filtrar os POIs com base na distância calculada para garantir que estejam dentro do raio `d-max`.
    - [x]  Retornar a lista de POIs que atendem ao critério de proximidade no formato JSON.
