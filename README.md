# iFace

* Funcionalidades:
-Criar conta
Essa funcionalidade é implementada pelo método createAccount e permite que o usuário crie uma nova conta no iFace. O nome e login de cada usuário é único no sistema, o método searchUser é usado para buscar no sistema se o nome ou login informado já então sendo utilizados.

-Fazer login
Essa funcionalidade é implementada pelo método loginUser, que por sua vez usa o método searchUser para buscar as informações do login informado pelo usuário e verificar se o login existe e se a senha foi digitada corretamente, para que possa realizar ou não o login.

-Editar perfil
Essa funcionalidade é implementada pelo método editAccount, que possibilita que o usuário altere o nome, o login e a senha de sua conta. o método searchUser é usado novamente para verificar se o novo nome ou login estão disponíveis para serem utilizados.

-Adicionar amigos
Essa funcionalidade é implementada pelo método sendInvite, que envia um convite de amizade para outro usuário, utilizando novamente o método seachUser para buscar, pelo nome, o usuário para o qual o convite deve ser enviado. O método answerInvites é usado para ver os convites de amizade recebidos e aceitá-los ou recusá-los.

-Criar comunidades
Essa funcionalidade é implementada pelo método createCommunity, que permite que o usuário crie uma nova comunidade, escolhendo o nome e a descrição. O nome da comunidade deve ser único no sistema, o método searchUser é usado para buscar no sistema se o nome fornecido já está sendo utilizado. As comunidades ainda não possuem funcionalidades, apenas descrição e lista de membros.

-Entrar em comunidades
Essa funcionalidade é implementada pelo método addMember, que pede que o usuário informe o nome da comunidade que deseja entrar. Se a comunidade for encontrada, o usuário é adicionado à lista de membros.

-Enviar mensagens
Essa funcionalidade é implementada pelo método sendMessage, o qual pede ao usuário que informe o nome do destinatário e o texto da mensagem. o método seachUser para buscar, pelo nome, o usuário para o qual a mensagem deve ser enviada, se o usuário for encontrado, a mensagem é adicionada à sua lista de mensagens.

-Recuperar informações do usuário 
Essa funcionalidade é implementada pelo método printUserInfo, que por sua vez usa os métodos printCommunities, friendsList e printMessge para printar as informações do usuário(comunidades das quais é dono, comunidades da quais é membro, lista de amigos e mensagens)

-Remover conta
Essa funcionalidade é implementada pelo método removeAccount, que deleta as informações do usuário do sistema. Saõ utilizados os métodos leaveCommunity para remover o usuário de todas as comunidades, removeFriend para desfazer todas as amizades e deleteSentMessage para excluir todas as mensagens enviadas. Essa funcionalidade ainda apresenta problemas.

* Classes:
- Main
Classe criada para iniciar o sistema e chamar os metódos necessários para realizar cada funcionalidade de acordo com a interação do usuário.

- Community
Classe criada com o objetivo de tratar cada comunidade como um objeto, possibilitando reunir as informações das comunidades (nome, descrição, dono da comunidade e membros) em um só lugar.

- Message
Classe criada com o objetivo de tratar cada mensagem como um objeto, possibilitando reunir as informações das mensagens (texto, remetente, destinatário) em um só lugar.

- User
Classe criada com o objetivo de tratar cada usuário como um objeto,  possibilitando reunir as informações dos usuários (nome, login, senha, mensagens, lista de amigos, convites de amizade) em um só lugar, e também reunir os métodos necessários para a interação com o usuário.

- Useful
A motivação para a criação dessa classe foi reunir métodos úteis que seriam usados em várias outras classes para evitar repetição de código, porém a classe não cumpriu bem seu objetivo.

* Distribuição dos Métodos
- createAccount
Método criado para criar uma nova conta no iFace.
O método foi colocado na classe User, pois a nova conta representa um usuário.

- loginUser
Método criado para fazer login em uma conta já existente do iFace.
O método foi colocada na classe User, pois tem relação com o usuário.

- editAccount
Método criado para editar as informações do perfil(nome, login e senha).
O método foi colocado na classe User, pois é necessário acessar as informações do usuário que está logado.

- searchUser
Método criado para buscar um usuário no sistema, para verificar as informações na hora de fazer login, verificar se o usuário já existe na hora de criar uma conta, para enviar convites de amizades, mensagens e adicionar em comunidades. A busca pode ser feita pelo nome ou pelo login do usuário.
O método foi colocado na classe User, pois é necessário para realizar as funcionalidades do usuário.

- friendsList
Método criado para printar a lista de amigos do usuário.
O método foi colocado na classe User, pois é necessário acessar as informações do usuário que está logado.

- answerInvites
Método criado para responder aos convites de amizade.
O método foi colocado na classe User, pois é necessário acessar as informações do usuário que está logado.

- sendInvite
Método criado para enviar convites de amizade a outros usuários.
O método foi colocado na classe User, pois está relacionado à interação entre dois usuários.

- createCommunity
Método criado para criar uma nova comunidade.
O método foi colocado na classe User, pois as comunidades criadas fazem parte das informações do usuário.

- addMember
Método criado para que o usuário possa entrar em uma comunidade.
O método foi colocado na classe User, pois a comunidade escolhida será adicionada à lista de comunidades do usuário.

- printCommunities
Método criado para printar a lista de comunidades do usuário, junto da sua descrição.
O método foi colocado na classe User, pois é necessário acessar as informações do usuário que está logado.

- printUserInfo
Método criado para printar as informações do usuário(login, lome, comunidades, amigos e mesagens).
O método foi colocado na classe User, pois é necessário acessar as informações do usuário que está logado.

- removeAccount
Método criado para remover a conta do usuário do sistema. Esse método ainda apresenta problemas.
O método foi colocado na classe User, pois é necessário acessar as informações do usuário que está logado.

- leaveCommunity
Método criado para que o usuário possa sair de uma comunidade.
O método foi colocado na classe User, pois é necessário acessar as informações do usuário que está logado.

- removeFriend
Método criado para desfazer uma amizade.
O método foi colocado na classe User, pois está relacionado à interação entre dois usuários.

- deleteSentMessage
Método criado para apagar uma mensagem que já foi enviada. 
O método foi colocado na classe User, pois é necessário acessar as informações do usuário que está logado.

- sendMessage
Método criado para que o usuário possa enviar mensagens.
O método foi colocado na classe Message, pois está relacionado ao preenchimento das informações de um objeto mensagem.

