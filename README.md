## Projeto DataGrade ##
jackson
# Contexto e Objetivo do Projeto 🎯

Nós, alunos do 2° semestre do curso de Banco de Dados da Faculdade de Tecnologia Jessen Vidal, desenvolvemos esse projeto de organizador de horários e restrições, com o objetivo e propósito de entregar uma solução que facilite e automatize a questão de restrições de professores quanto aos cursos e disciplinas que foram contemplados na FATEC de São José dos Campos, o produto irá notificar quando houver quaisquer conflito entre um restringimento de um professor com os horários e disponibilidades já fornecidas pela instituição Centro Paula Souza.

## 🚀 Requisitos Funcionais

- **Definição de horário de aula**: Permite configurar a grade de aulas para um semestre, garantindo que cada disciplina tenha o número correto de aulas semanais.  
  - Exemplo: A disciplina _Arquitetura e Modelagem de Banco de Dados_ possui 4 aulas por semana, cada uma definida individualmente.
  
- **Evitar sobreposição de horários**: Impede que um professor esteja atribuído a mais de uma disciplina no mesmo horário.

- **Gerenciamento acadêmico**:
  - Administração de cursos, disciplinas e professores.
  - Configuração de horários, permitindo ajustes conforme a organização de cada curso.

---

## 📖 Requisitos Não Funcionais

- **📘 Manual do Usuário**: Documento para guiar a utilização e implementação do sistema.
- **🗂️ Modelo Entidade-Relacionamento**: Estrutura do banco de dados representada visualmente.

---

## 🛠 Tecnologias Utilizadas
- **Java**
- **SceneBuilder**
- **Ide: Intellij**
- **MySQL**
- **Git/Github**
- **Br Modelo**


## Cronograma 📅

  | Evento | Data |
  | --- | --- |
  | Kick-off geral | 24/02 a 28/02 |
  | Sprint-1 | 10/03 a 30/03 |
  | Sprint Review/Planning | 31/03 a 04/04 |
  | Sprint-2 | 07/04 a 27/04 |
  | Sprint Review/Planning | 28/04 a 02/05 |
  | Sprint-3 | 05/05 a 25/05 |
  | Sprint Review/Planning | 26/05 a 28/05 |
  | Feira de Soluções | 17/06 |

# 📌 Backlog do Projeto

Abaixo está o backlog do projeto, agora com representações visuais para as prioridades.

| Issue | Título | Prioridade | Sprint |
|--------|--------|------------|--------|
| #DT10 | Criação da tabela BD | 🔴 ALTA | 2 |
| #DT11 | Alimentação BD | 🔴 ALTA | 2 |
| #DT12 | Modelo MER | 🟡 MÉDIA | 1 |
| #DT13 | Conexão BD | 🔴 ALTA | 2 |
| #DT14 | Criação de Grade | 🟡 MÉDIA | 2 |
| #DT15 | Visualização de grade | 🟡 MÉDIA | 2 |
| #DT16 | Tela de login | 🟡 MÉDIA | 2 |
| #DT17 | Logout | 🟡 MÉDIA | 2 |
| #DT18 | Tela restrição | 🟡 MÉDIA | 2 |
| #DT19 | Validações | 🔴 ALTA | 3 |
| #DT20 | Testes | 🟡 MÉDIA | 3 |
| #DT21 | Aviso de conflito | 🔴 ALTA | 3 |
| #DT22 | Protótipos | 🟡 MÉDIA | 1 |
| #DT23 | Ferramentas de trabalho | 🟡 MÉDIA | 1 |
| #DT24 | Documentos do projeto | 🟡 MÉDIA | 3 |
| #DT25 | Entrega | 🟡 MÉDIA | 3 |
| #DT26 | Verificação/replanejamento do Banco de Dados sobre os Slots | 🔴 ALTA | 3 |


# 📌 User Stories do Cliente

| Título | User Story |
|--------|------------|
| Criação de Grade | Como coordenador, quero definir e visualizar uma grade clara e organizada, para facilitar a alocação de disciplinas e professores. |
| Visualização de grade | Como coordenador, quero acessar facilmente a grade de horários das aulas, para verificar e ajustar as alocações. |
| Tela restrição | Como professor, quero acessar uma tela para definir meus horários indisponíveis, evitando alocações conflitantes com minha agenda. |
| Aviso de conflito | Como coordenador, quero receber alertas caso haja conflito de horários entre professores e disciplinas, para corrigir antes da confirmação. |
| Documentos do projeto | Como coordenador, quero ter documentação completa do sistema, para facilitar o uso e futuras manutenções. |


# Modelo entidade-relacionamento 

![diagrama2_page-0001](https://github.com/user-attachments/assets/55ca95b2-a6ee-40d9-b9c6-89d604b67ac0)


# Equipe de desenvolvimento 👥

| Foto | Aluno | Função                                                                                                  |
|-|-|-|
| ![Caue](https://github.com/user-attachments/assets/f77aad10-6dff-4e73-83e5-218d90bd2652) | <div align="center"> Cauê Gandini | Product Owner |
| ![Lucas](https://github.com/user-attachments/assets/0063daa4-e83e-4d22-9d76-71b5482d56df) | <div align="center"> Lucas Silva Sousa | Scrum Master |
| ![Abimael foto](https://github.com/user-attachments/assets/e402d840-1f14-48db-aceb-6931bd62bd86) |<div align="center"> Abimael | Dev |
| ![Andre](https://github.com/user-attachments/assets/e5b1612b-3685-41b8-900f-9d3ed0f48697) |<div align="center"> André Diniz | Dev|
| ![Jakson](https://github.com/user-attachments/assets/c5c1f6c3-c145-4e98-be5f-4f4a281fbdb3) | <div align="center"> Jackson Tadeu | Dev |
|  | <div align="center"> João Andrade | Dev |
| ![Thor](https://github.com/user-attachments/assets/1953daad-e890-47b8-b646-3e40af462d2c) | <div align="center"> Thor Lyndgaard | Dev |
