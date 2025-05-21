# 📋 User Stories

Este documento descreve as **User Stories** do projeto, organizadas por **Sprints**, com base nos issues definidos no backlog, incluindo as respectivas definições de pronto (*Ready*) e pronto para entrega (*Done*).

---

## 🚀 Sprint 1 – Planejamento e Estrutura Inicial

| Issue | Título                  | User Story |
|-------|-------------------------|------------|
| #12   | Modelo MER              | Como desenvolvedor, quero modelar o banco de dados usando um Modelo Entidade-Relacionamento (MER), para garantir uma estrutura lógica e organizada antes da implementação física. |
|       | **Ready**               | Ter em mente todo o modelo de negócio do projeto. |
|       | **Done**                | Possuir o modelo MER com todas as entidades e relações definidas. |
| #22   | Protótipos              | Como desenvolvedor, quero desenvolver protótipos das telas principais do sistema, para validar a experiência do usuário antes do desenvolvimento final. |
|       | **Ready**               | Ter esquematizado toda a estrutura das telas e seus componentes. |
|       | **Done**                | Todos os membros devem ter elaborado algum protótipo de tela em ferramentas como Canva ou SceneBuild. |
| #23   | Ferramentas de trabalho | Como membro da equipe, quero ter acesso a ferramentas colaborativas como repositório Git, IDEs, e meios de comunicação. |
|       | **Ready**               | Necessidade de alinhar as ferramentas mais adequadas para o projeto. |
|       | **Done**                | O grupo entrou em consenso sobre as ferramentas que serão utilizadas durante o projeto. |

---

## ⚙️ Sprint 2 – Implementação Inicial

| Issue | Título                 | User Story |
|-------|------------------------|------------|
| #10   | Criação da tabela BD   | Como desenvolvedor, quero criar tabelas no banco de dados com estrutura relacional, para suportar as operações do sistema. |
|       | **Ready**              | Ter o modelo MER em mente. |
|       | **Done**               | Tabelas criadas em um modelo relacional funcional no SGBD. |
| #13   | Conexão BD             | Como desenvolvedor, quero conectar a aplicação ao banco de dados, para permitir operações de leitura e escrita de forma segura e eficiente. |
|       | **Ready**              | Banco de dados modelado e implementado no SGBD. |
|       | **Done**               | Banco de dados conectado ao código-fonte do projeto, permitindo atualizações de dados. |
| #11   | Alimentação BD         | Como desenvolvedor, quero alimentar o banco de dados com os registros iniciais, para que as funcionalidades do sistema possam ser utilizadas. |
|       | **Ready**              | Necessidade de extrair dados diretamente de documentos oficiais da FATEC. |
|       | **Done**               | Dados de disciplinas, cursos e professores alimentados corretamente no banco. |
| #16   | Tela de login          | Como usuário, quero realizar login com segurança usando minhas credenciais, para acessar minha conta e utilizar as funcionalidades do meu usuário. |
|       | **Ready**              | Saber quais dados do usuário serão utilizados no login, como e-mail do professor. |
|       | **Done**               | Tela funcional com verificação de credenciais e permissões. |
| #14   | Criação de Grade       | Como coordenador, quero visualizar uma grade clara e organizada, para facilitar a navegação e a tomada de decisões. |
|       | **Ready**              | Ter banco de dados integrado e função de cadastro da grade estruturada. |
|       | **Done**               | Coordenador consegue cadastrar e visualizar a grade de horários com os dados inseridos. |
| #17   | Logout                 | Como desenvolvedor, quero implementar um Logout no sistema, para proteger as informações do usuário. |
|       | **Ready**              | Tela de login e menu principal precisam estar prontas. |
|       | **Done**               | Função permite sair do menu e reiniciar o acesso ao sistema. |
| #18   | Tela restrição         | Como professor, quero ter uma tela onde possa configurar as minhas restrições, para deixar salvo os dias e horários que não posso dar aula. |
|       | **Ready**              | Tela de menu pronta, banco de dados integrado e consultas funcionando. |
|       | **Done**               | Tela permite o cadastro e a persistência das restrições que serão consultadas na criação da grade. |

---

## ✅ Sprint 3 – Validações e Entregas

| Issue | Título                                           | User Story |
|-------|--------------------------------------------------|------------|
| #19   | Validações                                       | Como desenvolvedor, desejo testar validações de restrições e regras de negócio, para garantir que o produto esteja condizente. |
|       | **Ready**                                        | Cadastro de restrições e criação de grade precisam estar funcionais. |
|       | **Done**                                         | Validações respeitam todas as restrições de professores durante a criação da grade. |
| #20   | Testes                                           | Como desenvolvedor, desejo realizar testes no programa, para garantir que requisitos funcionais estejam de acordo com o projeto. |
|       | **Ready**                                        | Projeto completo e funcional para permitir testes integrais. |
|       | **Done**                                         | Cada membro da equipe testou intensamente o sistema buscando falhas e brechas. |
| #21   | Aviso de conflito                                | Como coordenador, quero visualizar se minha grade não vai interferir em restrições, para não cadastrar informações erradas. |
|       | **Ready**                                        | Validação de restrições implementada. |
|       | **Done**                                         | Tela exibe mensagens claras sobre os conflitos de restrições durante a criação da grade. |
| #25   | Entrega                                          | Como desenvolvedor, desejo entregar meu produto padronizado e organizado, para criar um ambiente melhor para o cliente. |
|       | **Ready**                                        | Projeto completamente funcional e sem pendências de desenvolvimento. |
|       | **Done**                                         | Sistema executável com facilidade e banco de dados configurado de forma clara e simples. |
| #26   | Verificação/replanejamento do BD sobre os Slots | Como desenvolvedor, quero replanejar o banco de dados para fazer sentido dentro do contexto de slots. |
|       | **Ready**                                        | Banco de dados atual atinge um ponto onde não atende mais a estrutura necessária para slots. |
|       | **Done**                                         | Novo modelo de banco consensual e compatível com a lógica de slots e horários. |
| #24   | Documentos do projeto                            | Como desenvolvedor, desejo documentar meu projeto para fins de organização e facilitação para o cliente na questão de manuais. |
|       | **Ready**                                        | Projeto totalmente finalizado. |
|       | **Done**                                         | Toda a documentação está completa, clara e formalmente organizada. |

---

## 📌 Observações Finais

- **Sprint 1**: Estruturação do projeto, criação de protótipos e preparação do ambiente de desenvolvimento.
- **Sprint 2**: Implementação de funcionalidades centrais, integração com banco de dados e autenticação.
- **Sprint 3**: Testes, validações, gestão de conflitos, documentação e entrega formal do projeto.

