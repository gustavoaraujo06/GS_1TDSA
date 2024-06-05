class Usuario:
    contador_id = 0
    def __init__(self, nome, email, senha):
        self.id = Usuario.contador_id
        Usuario.contador_id += 1

        self.nome = nome
        self.email = email
        self.senha = senha
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
    def __str__(self) -> str:
        return (f"\nProjeto: {self.nome}" 
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
class Admin:
    contador_id = 0
    def __init__(self, nome, email, senha):
        self.id = Admin.contador_id
        Admin.contador_id += 1

        self.nome = nome
        self.email = email
        self.senha = senha
class Endereco:
    def __init__(self, logradouro, numero, cep, complemento):
        self.logradouro = logradouro
        self.numero = numero
        self.cep = cep
        self.complemento = complemento
usuarios = [Admin("admin", "admin@example.com", "admin123")]
projetos = []

# Função de Login/Criar Conta
def login_criar_conta():
    print("1. Login")
    print("2. Criar Conta")
    opcao = input("Escolha uma opção: ")
    if opcao == "1":
        email = input("Email: ")
        senha = input("Senha: ")
        for usuario in usuarios:
            if usuario.email == email and usuario.senha == senha:
                print(f"Bem-vindo, {usuario.nome}!")
                return usuario
        print("Credenciais inválidas!")
        return None
    elif opcao == "2":
        nome = input("Nome: ")
        email = input("Email: ")
        senha = input("Senha: ")
        id = len(usuarios) + 1
        novo_usuario = Usuario(nome, email, senha)
        usuarios.append(novo_usuario)
        print("Conta criada com sucesso!")
        return novo_usuario
    else:
        print("Opção inválida!")
        return None

# Função para criar projeto
def criar_projeto(usuario):
    if isinstance(usuario, Admin):
        nome = input("Nome do projeto: ")
        descricao = input("Descrição do projeto: ")
        rua = input("Rua: ")
        cidade = input("Numero: ")
        cep = input("CEP: ")
        complemento = input("Complemento: ")
        localizacao = Endereco(rua, cidade, cep, complemento)
        novo_projeto = Projeto(nome, descricao, usuario, localizacao)
        print("Projeto criado com sucesso!")
        projetos.append(novo_projeto)
    else:
        print("Apenas administradores podem criar projetos.")

def criar_equipe(projeto, usuario):
    if isinstance(usuario, Admin) and projeto.criador == usuario:
        nome = input("Nome da equipe: ")
        descricao = input("Descrição da equipe: ")
        nova_equipe = Equipe(nome, descricao)
        projeto.equipes.append(nova_equipe)
        print("Equipe criada com sucesso!")
    else:
        print("Apenas administradores e criadores de projeto podem criar equipes.")

def adicionar_tarefa(projeto, index_equipe, usuario):
    if isinstance(usuario, Admin) and projeto.criador == usuario:
        if(index_equipe >= len(projeto.equipes)):
            print("Equipe não encontrada!")
            return
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

        



# Menu principal
def menu_principal():
    usuario_logado = None
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
        elif opcao == "2" and usuario_logado and isinstance(usuario_logado, Admin):
            criar_projeto(usuario_logado)
        elif opcao == "3" and usuario_logado and isinstance(usuario_logado, Admin):
            if len(projetos) == 0:
                print("Nenhum projeto disponível!")
                continue
            for projeto in projetos:
                print(f"{projeto.id + 1}. {projeto.nome}")
            index_projeto = int(input("Escolha um projeto: ")) - 1
            criar_equipe(projetos[index_projeto], usuario_logado)
        elif opcao == "4" and usuario_logado and isinstance(usuario_logado, Admin):
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
            adicionar_tarefa(projetos[index_projeto], index_equipe, usuario_logado)
        elif opcao == "7":
            break
        else:
            print("Opção inválida ou acesso não autorizado!")

# Executar o menu principal
menu_principal()