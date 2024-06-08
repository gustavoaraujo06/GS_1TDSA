#classes do projeto, adicionadas para facilidade de codigo e para condizer com as materias de Banco de dados
#e domain driven design

#classe usuario, com atributos id, nome, email e senha
class Usuario:
    #eu adicionei um contador a todas as classes para replicar o comportamento do autoincrement de um banco :)
    contador_id = 0
    def __init__(self, nome, email, senha):
        self.id = Usuario.contador_id
        Usuario.contador_id += 1

        self.nome = nome
        self.email = email
        self.senha = senha

#classe admin, que herda de usuario, usada para verificação de permissao
class Admin(Usuario):
    def __init__(self, nome, email, senha):
        super().__init__(nome, email, senha)

#classe projeto, a classe principal da solucao
class Projeto:
    contador_id = 0
    def __init__(self, nome, descricao, criador, localizacao):
        self.id = Projeto.contador_id
        Projeto.contador_id += 1

        self.nome = nome
        self.descricao = descricao
        self.criador = criador
        self.localizacao = localizacao
        self.equipes = []
        self.tarefas = []
    #sobrescrita do metodo toString para nao precisar de varios prints nos outros metodos
    def __str__(self) -> str:
        return (f"\n{self.id + 1}."
            f"\nProjeto: {self.nome}" 
            f"\nDescrição: {self.descricao}" 
            f"\nCriador: {self.criador.nome}" 
            f"\nLocalização: {self.localizacao.logradouro}, {self.localizacao.numero}, {self.localizacao.cep}, {self.localizacao.complemento}")
class Tarefa:
    contador_id = 0
    def __init__(self, nome, descricao, data_inicio, data_fim):
        self.id = Tarefa.contador_id
        Tarefa.contador_id += 1

        self.nome = nome
        self.descricao = descricao
        self.data_inicio = data_inicio
        self.data_fim = data_fim
class Equipe:
    contador_id = 0
    def __init__(self, nome, descricao):
        self.id = Equipe.contador_id
        Equipe.contador_id += 1

        self.nome = nome
        self.descricao = descricao
        self.membros = []
        self.tarefas = []

    def __str__(self) -> str:
        retorno = f"\n{self.id +1 }.\nEquipe: {self.nome}" + f"\nDescrição: {self.descricao} + \nMembros:"

        for membro in self.membros:
            retorno += f"\n{membro.nome}"

        retorno += "\nTarefas:"

        for tarefa in self.tarefas:
            retorno += f"\n{tarefa.nome}: {tarefa.descricao} - {tarefa.data_inicio} até {tarefa.data_fim}"
        return retorno
class Endereco:
    def __init__(self, logradouro, numero, cep, complemento):
        self.logradouro = logradouro
        self.numero = numero
        self.cep = cep
        self.complemento = complemento
#lista de usuarios, ja começa com um admin que é o padrao
usuarios = [Admin("admin", "admin@admin.com", "admin123")]
projetos = []

# Função de Login/Criar Conta
def login_criar_conta():
    print("1. Login")
    print("2. Criar Conta")
    opcao = input("Escolha uma opção: ")
    if opcao == "1":
        email = input("Email: ")
        senha = input("Senha: ")
        #verifica se o usuario esta na lista e se a senha condiz
        for usuario in usuarios:
            if usuario.email == email and usuario.senha == senha:
                print(f"\nBem-vindo, {usuario.nome}!")
                return usuario
        print("\nCredenciais inválidas!")
    #cria um novo usuario
    elif opcao == "2":
        nome = input("Nome: ")
        email = input("Email: ")
        senha = input("Senha: ")
        novo_usuario = Usuario(nome, email, senha)
        usuarios.append(novo_usuario)
        print("Conta criada com sucesso!")
        return novo_usuario
    else:
        print("Opção inválida!")

# Função para criar projeto
def criar_projeto(usuario):
    #verificacao se o usuario é admin
    if isinstance(usuario, Admin):
        nome = input("Nome do projeto: ")
        descricao = input("Descrição do projeto: ")
        logradouro = input("Logradouro: ")
        numero = input("Numero: ")
        cep = input("CEP: ")
        complemento = input("Complemento: ")
        localizacao = Endereco(logradouro, numero, cep, complemento)
        novo_projeto = Projeto(nome, descricao, usuario, localizacao)
        print("Projeto criado com sucesso!")
        projetos.append(novo_projeto)
    else:
        print("Apenas administradores podem criar projetos.")

def criar_equipe(projeto, usuario):
    if projeto.criador == usuario:
        nome = input("Nome da equipe: ")
        descricao = input("Descrição da equipe: ")
        nova_equipe = Equipe(nome, descricao)
        projeto.equipes.append(nova_equipe)
        print("Equipe criada com sucesso!")
    else:
        print("Apenas administradores e criadores de projeto podem criar equipes.")

def adicionar_tarefa(projeto, index_equipe, usuario):
    if projeto.criador == usuario:
        equipe = projeto.equipes[index_equipe]
        nome = input("Nome da tarefa: ")
        descricao = input("Descrição da tarefa: ")
        data_inicio = input("Data de início da tarefa: ")
        data_fim = input("Data de fim da tarefa: ")
        nova_tarefa = Tarefa(nome, descricao, data_inicio, data_fim)
        equipe.tarefas.append(nova_tarefa)
        print("Tarefa adicionada com sucesso!")
    else:
        print("Apenas administradores e criadores de projeto podem adicionar tarefas.")

def entrar_equipe(projeto, index_equipe, usuario):
    #validacao de entrada de usuario
    if(index_equipe >= len(projeto.equipes)):
        print("Equipe não encontrada!")
        return
    equipe = projeto.equipes[index_equipe]
    equipe.membros.append(usuario)
    print("Entrou na equipe com sucesso!")

def status_projeto(projeto):
    print(projeto)
    for equipe in projeto.equipes:
        print(equipe)


# Menu principal
def menu_principal():
    usuario_logado = None
    #estrutura de repeticao para o menu, funciona ate o usuario escolher sair
    while True:
        print("\nMenu Principal")
        print("1. Login/Criar Conta")
        if usuario_logado:
            if isinstance(usuario_logado, Admin):
                print("2. Criar Projeto")
                print("3. Criar Equipe em um Projeto")
                print("4. Adicionar Tarefas a uma Equipe")
            print("5. Participar de uma Equipe em um Projeto")
            print("6. Acompanhar Situação de Projeto, Equipe e Tarefas")
            print("7. Sair")
        opcao = input("Escolha uma opção: ")
        
        if opcao == "1":
            usuario_logado = login_criar_conta()
        elif opcao == "2" and usuario_logado:
            #nesse caso a verificacao de permissao é feita dentro da funcao
            criar_projeto(usuario_logado)
        #ja nesse, é feita anteriormente
        elif opcao == "3" and usuario_logado and isinstance(usuario_logado, Admin):
            #verificacao se pelo menos existe algum projeto
            if len(projetos) == 0:
                print("Nenhum projeto disponível!")
                continue

            for projeto in projetos:
                print(projeto)

            index_projeto = int(input("Escolha um projeto: ")) - 1

            #verificacao se o projeto existe
            if(index_projeto >= len(projetos) or index_projeto < 0):
                print("Projeto não encontrado!")
                continue

            criar_equipe(projetos[index_projeto], usuario_logado)
        elif opcao == "4" and usuario_logado and isinstance(usuario_logado, Admin):

            #novamente, mesmas verificacoes da funcao anterior
            if len(projetos) == 0:
                print("Nenhum projeto disponível!")
                continue

            for projeto in projetos:
                print(projeto)

            index_projeto = int(input("Escolha um projeto: ")) - 1

            if(index_projeto >= len(projetos) or index_projeto < 0):
                print("Projeto não encontrado!")
                continue

            #aqui ja temos uma verificacao diferente, agora para o numero de equipes
            if(len(projetos[index_projeto].equipes) == 0):
                print("Nenhuma equipe disponível!")
                continue

            for equipe in projetos[index_projeto].equipes:
                print(equipe)
                
            index_equipe = int(input("Escolha uma equipe: ")) - 1

            #mesma logica da verificacao de projetos, mas para equipes
            if(index_equipe >= len(projeto.equipes) or index_equipe < 0):
                print("Equipe não encontrada!")
                continue
            
            adicionar_tarefa(projetos[index_projeto], index_equipe, usuario_logado)
    
        elif opcao == "5" and usuario_logado:
            #mesma logica dos demais
            if len(projetos) == 0:
                print("Nenhum projeto disponível!")
                continue
            for projeto in projetos:
                print(projeto)
            index_projeto = int(input("Escolha um projeto: ")) - 1

            if(index_projeto >= len(projetos) or index_projeto < 0):
                print("Projeto não encontrado!")
                continue

            if(len(projetos[index_projeto].equipes) == 0):
                print("Nenhuma equipe disponível!")
                continue
            for equipe in projetos[index_projeto].equipes:
                print(equipe)
                
            index_equipe = int(input("Escolha uma equipe: ")) - 1

            if(index_equipe >= len(projeto.equipes) or index_equipe < 0):
                print("Equipe não encontrada!")
                continue

            entrar_equipe(projetos[index_projeto], index_equipe, usuario_logado)
        elif opcao == "6" and usuario_logado:
            if len(projetos) == 0:
                print("Nenhum projeto disponível!")
                continue
            for projeto in projetos:
                print(projeto)
            index_projeto = int(input("Escolha um projeto: ")) - 1

            if(index_projeto >= len(projetos) or index_projeto < 0):
                print("Projeto não encontrado!")
                continue

            status_projeto(projetos[index_projeto])
        elif opcao == "7":
            break
        else:
            print("Opção inválida ou acesso não autorizado!")

# Executar o menu principal
menu_principal()