Relatório – Atividade de Git com Robocode

"Robô SilvioSantos: ele rarrae seu maoee quando você menos hihiiiiii"

Atividade da disciplina ICO 7862 da 1 fase do curso de ADS do IFSC SJ

1. Introdução

O Robocode é uma plataforma que permite desenvolver robôs de batalha utilizando a linguagem Java. Cada robô é programado para executar ações automaticamente durante as batalhas, como movimentar-se, localizar adversários e efetuar disparos. A atividade utilizou esse ambiente como contexto para o aprendizado de programação e, principalmente, para a aplicação de conceitos de controle de versão com Git e GitHub.
Desde o início do projeto, o grupo definiu que o foco da atividade seria compreender o fluxo de desenvolvimento colaborativo utilizando Git. Por esse motivo, optou-se por desenvolver um robô com funcionalidades simples, priorizando a organização do código, o versionamento e a integração das alterações realizadas por cada integrante. O robô final recebeu o nome SilvioSantos.

2. Objetivos da Atividade

Os principais objetivos da atividade foram:
Desenvolver um robô funcional para o Robocode utilizando Java.
Aplicar os conceitos básicos de programação orientada a objetos.
Aprender a utilizar o Git como ferramenta de controle de versão.
Utilizar o GitHub para armazenamento e colaboração do projeto.
Desenvolver o projeto em equipe por meio da divisão de tarefas.
Praticar a criação de branches, commits, merges e resolução de conflitos.
Integrar diferentes versões do robô até chegar a uma versão final estável.

3. Descrição da Atividade

O projeto foi desenvolvido pelos integrantes Kaio, Bruno e Alan. Inicialmente foi criado um repositório no GitHub, onde cada integrante passou a desenvolver sua própria versão do robô em uma branch individual.
Cada membro implementou pequenas melhorias no código, criando versões sucessivas do robô. Periodicamente essas versões eram integradas por meio de operações de merge, permitindo reunir as contribuições de todos os integrantes em uma única versão do projeto. Após cada integração, o robô era executado no Robocode para verificar se todas as funcionalidades permaneciam funcionando corretamente.
Durante o desenvolvimento foram criadas diferentes versões do robô, sendo a versão 3.0 escolhida como versão final por apresentar um comportamento estável e reunir as principais melhorias implementadas pelo grupo.
O robô final, denominado SilvioSantos, possui um comportamento simples. Sua movimentação consiste em avançar uma distância com pequena variação aleatória, girar 90 graus e realizar uma varredura de 360 graus com o canhão em busca de adversários. Quando encontra um inimigo, dispara tiros com potência diferente de acordo com a distância: potência 2 para alvos próximos e potência 1 para alvos mais distantes. Também foram implementadas reações simples ao ser atingido por disparos e ao colidir com paredes, aumentando sua capacidade de sobrevivência durante as batalhas.
A simplicidade dessas funcionalidades foi uma escolha do grupo, mantendo o projeto compatível com os objetivos da disciplina e concentrando os esforços na aprendizagem do uso do Git e do GitHub.

4. Estrutura do Git Utilizada

O projeto foi organizado em um repositório hospedado no GitHub.
Para facilitar o desenvolvimento colaborativo foram utilizadas diferentes branches:
main: versão principal do projeto.
dev: utilizada para integração e testes das alterações.
Kaio: desenvolvimento do script de Kaio.
Bruno: desenvolvimento do script de Bruno.
Alan: desenvolvimento do script de Alan.
Cada integrante realizou commits durante o desenvolvimento de sua versão do robô, registrando a evolução do código e permitindo acompanhar o histórico das alterações.
Após períodos de desenvolvimento individual, as branches eram integradas por meio de merge, reunindo todas as modificações em uma versão única do robô. Durante esse processo também ocorreram conflitos de merge, que precisaram ser resolvidos manualmente antes da conclusão da integração. Essa etapa permitiu compreender, na prática, como o Git identifica alterações concorrentes em um mesmo arquivo e como essas situações podem ser solucionadas.
Embora o GitHub permita a utilização de Pull Requests para integração das alterações, nesta atividade a integração foi realizada diretamente por meio dos comandos de merge do Git.

5. Resultados e Aprendizados

A atividade permitiu compreender o funcionamento do Git em um cenário de desenvolvimento colaborativo.
Entre os principais aprendizados destacam-se a criação e utilização de branches, realização de commits, sincronização do repositório por meio de pull e push, integração de código utilizando merge e resolução de conflitos quando diferentes versões modificavam o mesmo arquivo.
Também foi possível observar como pequenas alterações realizadas por diferentes integrantes podem ser reunidas em um único projeto sem perder o histórico de desenvolvimento.
Do ponto de vista da programação, o grupo implementou funcionalidades básicas no robô, como movimentação, busca por inimigos, disparos com diferentes potências e reações simples aos eventos do ambiente. Embora o comportamento do robô não tenha sido desenvolvido com foco em alto desempenho competitivo, o resultado atendeu aos objetivos propostos pela atividade e demonstrou a aplicação dos conceitos estudados.

6. Conclusão

O desenvolvimento do robô SilvioSantos proporcionou uma experiência prática tanto com programação em Java quanto com o uso do Git e do GitHub.
A utilização de branches individuais, commits frequentes e merges permitiu compreender como equipes organizam o desenvolvimento de software em projetos colaborativos. Além disso, a resolução de conflitos de merge mostrou a importância do controle de versão na integração segura das contribuições de diferentes desenvolvedores.
Ao final da atividade foi obtido um robô funcional, cuja versão 3.0 reuniu as principais melhorias implementadas pelo grupo. Mais importante do que o desempenho do robô foi a experiência adquirida com o fluxo de desenvolvimento colaborativo, conhecimento que poderá ser aplicado em projetos futuros.

7. Anexos

Para complementar este relatório, podem ser apresentados os seguintes materiais:

- SilvioSantos em ação:
  
https://github.com/user-attachments/assets/3f1a5fb2-a036-40a2-907c-4849dfb7b4f8

- Histórico de commits realizados pelos integrantes.

https://github.com/kaio-ar/ICORobo/commits/main

- Exemplo de merge entre branches.

https://github.com/kaio-ar/ICORobo/commit/2b167402e69e957d3bb3f23097a7a1f53c069c90

- Exemplo de resolução de conflito de merge.

https://github.com/kaio-ar/ICORobo/commit/15b42788f8fb15482d82b175c8b94b3fd8a407ea

- Estrutura das branches utilizadas no projeto.

<img width="362" height="487" alt="Branches" src="https://github.com/user-attachments/assets/cdbaf2b8-234e-423d-8eb5-e9f56f752c0e" />

