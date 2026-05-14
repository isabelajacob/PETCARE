# Sistema PetCare – AC2

Projeto desenvolvido para a disciplina de Desenvolvimento Web Back-End utilizando Spring Boot, JPA e banco de dados em memória (H2).

O sistema realiza o gerenciamento de:

- Tutores (donos de animais)
- Animais
- Veterinários
- Consultas
- Prontuários
- Vacinações

---

# Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Lombok
- H2 Database (in-memory)
- Maven
- HTML e JavaScript
- Postman

---

# Funcionalidades

## Tutores
- Cadastro de tutores
- Listagem de tutores
- Busca por ID

## Animais
- Cadastro de animais vinculados a um tutor
- Listagem de animais
- Busca por ID
- Listagem de animais por tutor

## Veterinários
- Cadastro de veterinários com especialidade
- Listagem de veterinários
- Busca por ID

## Consultas
- Agendamento de consultas com validação de conflito de horário
- Validação de especialidade do veterinário x espécie do animal
- Histórico de consultas por animal
- Consultas por veterinário

## Prontuários
- Registro de prontuário vinculado a uma consulta
- Histórico completo de prontuários por animal

## Vacinação
- Registro de vacinas por animal
- Listagem do histórico de vacinas por animal

---

# Estrutura do Projeto

```
src/main/java/com/facens/petcare
├── controller
│   ├── AnimalController.java
│   ├── ConsultaController.java
│   ├── ProntuarioController.java
│   ├── TutorController.java
│   ├── VacinaController.java
│   └── VeterinarioController.java
├── model
│   ├── Animal.java
│   ├── Consulta.java
│   ├── Prontuario.java
│   ├── Tutor.java
│   ├── Vacina.java
│   └── Veterinario.java
├── repository
│   ├── AnimalRepository.java
│   ├── ConsultaRepository.java
│   ├── ProntuarioRepository.java
│   ├── TutorRepository.java
│   ├── VacinaRepository.java
│   └── VeterinarioRepository.java
├── service
│   ├── AnimalService.java
│   ├── ConsultaService.java
│   ├── ProntuarioService.java
│   ├── TutorService.java
│   ├── VacinaService.java
│   └── VeterinarioService.java
└── PetcareApplication.java

src/main/resources
├── static
│   └── index.html
├── data.sql
└── application.properties
```

---

# Arquitetura Utilizada

O projeto foi desenvolvido utilizando arquitetura em camadas:

## Model
Representa as tabelas do banco de dados, mapeadas com JPA/Hibernate via anotação `@Entity`.

## Repository
Responsável pela comunicação com o banco utilizando Spring Data JPA. Extende `JpaRepository`, eliminando a necessidade de escrever SQL manualmente.

## Service
Responsável pelas regras de negócio e validações, como verificação de conflito de agenda e compatibilidade de especialidade.

## Controller
Responsável pelos endpoints da API REST, recebendo as requisições HTTP e retornando as respostas.

---

# Relacionamentos

## Tutor ↔ Animal
Relacionamento OneToMany — um tutor pode ter vários animais. Animal possui chave estrangeira `tutor_id`.

## Animal ↔ Consulta
Relacionamento ManyToOne — um animal pode ter várias consultas.

## Veterinário ↔ Consulta
Relacionamento ManyToOne — um veterinário pode ter várias consultas.

## Consulta ↔ Prontuário
Relacionamento ManyToOne — cada prontuário está vinculado a uma consulta.

## Animal ↔ Vacina
Relacionamento ManyToOne — um animal pode ter várias vacinas registradas.

---

# Endpoints

## Tutores
```http
POST   /tutores
GET    /tutores
GET    /tutores/{id}
```

## Animais
```http
POST   /animais/tutor/{tutorId}
GET    /animais
GET    /animais/{id}
GET    /animais/tutor/{tutorId}
```

## Veterinários
```http
POST   /veterinarios
GET    /veterinarios
GET    /veterinarios/{id}
```

## Consultas
```http
POST   /consultas
GET    /consultas/animal/{animalId}
GET    /consultas/veterinario/{vetId}
```

## Prontuários
```http
POST   /prontuarios
GET    /prontuarios/animal/{animalId}
```

## Vacinas
```http
POST   /vacinas/animal/{animalId}
GET    /vacinas/animal/{animalId}
```

---

# Regras de Negócio

- Não é permitido agendar uma consulta se o veterinário já possui outra consulta no mesmo horário (conflito de agenda)
- O veterinário só pode atender animais cuja espécie corresponda à sua especialidade
- Todo animal deve estar obrigatoriamente vinculado a um tutor no momento do cadastro
- O prontuário só pode ser registrado vinculado a uma consulta existente
- Busca por ID retorna erro caso o recurso não exista

---

# Banco de Dados

O projeto utiliza o **H2 Database** em modo in-memory, sem necessidade de instalação externa. O Spring cria as tabelas automaticamente via JPA, e o arquivo `data.sql` popula dados iniciais a cada inicialização.

O console do H2 pode ser acessado em: `http://localhost:8080/h2-console`

- **JDBC URL:** `jdbc:h2:mem:petcaredb`
- **User:** `sa`
- **Password:** *(em branco)*

---

# Frontend

O projeto possui um frontend simples utilizando HTML e JavaScript puro, acessível ao iniciar a aplicação.

Funcionalidades da interface:

- Cadastro de tutores, animais e veterinários
- Agendamento de consultas
- Registro e histórico de prontuários
- Registro e histórico de vacinas
- Listagem de animais e tutores

---


#Isabela de Oliveira Jacob e Ana Luiza Araujo

Projeto desenvolvido para a AC2 da disciplina de Desenvolvimento Web Back-End – ADS.
