document.addEventListener('DOMContentLoaded', function () {
    const formulario = document.querySelector('#cadastro');
    const Inome = document.getElementById('nome');
    const Idescricao = document.getElementById('descricao');
    const Ivalor = document.getElementById('valor');
    const Idisponibilidade = document.querySelectorAll('input[name="disponibilidade"]');

    function showForm(formId) {
        const forms = document.querySelectorAll('.form-container');

        forms.forEach(form => form.style.display = 'none');

        const formToShow = document.getElementById(`form-${formId}`);
        if (formToShow) {
            formToShow.style.display = 'block';
        }

        document.getElementById('list-container').style.display = 'none';

        if (formId === 'apagar') {
            exibirLivrosParaApagar();
        }
    }

    function cadastrar() {
        const disponibilidade = document.querySelector('input[name="disponibilidade"]:checked');
        if (!disponibilidade) {
            alert("Por favor, selecione a disponibilidade!");
            return;
        }
    
        fetch("http://localhost:8080/api3/produto", {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: 'POST',
            body: JSON.stringify({
                nome: Inome.value,
                descricao: Idescricao.value,
                valor: parseFloat(Ivalor.value),
                disponibilidade: disponibilidade.value
            })
        })
        .then(res => {
            if (res.ok) {
                alert("Produto cadastrado com sucesso!");
                limpar();
            } else {
                throw new Error("Erro ao cadastrar produto.");
            }
        })
        .catch(error => {
            console.error("Erro:", error);
            alert("Não foi possível cadastrar o produto.");
        });
    }
    

    function listar() {
        fetch("http://localhost:8080/api3/produto", {
            method: 'GET',
            headers: {
                'Accept': 'application/json'
            }
        })
            .then(res => res.json())
            .then(data => {
                const listaContainer = document.getElementById('list-container');
                listaContainer.style.display = 'block';
                listaContainer.innerHTML = ""; 
    
                if (data.length === 0) {
                    listaContainer.innerHTML = "<p>Nenhum produto encontrado.</p>";
                    return;
                }
    
                const ul = document.createElement('ul');
                data.forEach(produto => {
                    const li = document.createElement('li');
                    li.innerHTML = `
                        <strong>Nome:</strong> ${produto.nome}<br>
                        <strong>Descrição:</strong> ${produto.descricao}<br>
                        <strong>Valor:</strong> R$ ${produto.valor.toFixed(2)}<br>
                        <strong>Disponibilidade:</strong> ${produto.disponibilidade.toLowerCase() === 'sim' ? 'Sim' : 'Não'}
                    `;
                    ul.appendChild(li);
                });
                listaContainer.appendChild(ul);
            })
            .catch(error => {
                console.error("Erro ao listar produtos:", error);
                alert("Erro ao listar produtos.");
            });
    }
    
    

    function limpar() {
        Inome.value = "";
        Idescricao.value = "";
        Ivalor.value = "";
        Idisponibilidade.forEach(input => input.checked = false);
    }

    document.getElementById('btn-cadastrar').addEventListener('click', () => showForm('cadastrar'));
    document.getElementById('btn-consultar').addEventListener('click', listar);
    document.getElementById('btn-submit-cadastrar').addEventListener('click', cadastrar);
    document.getElementById('btn-consultar').addEventListener('click', () => {
        showForm('consultar');
        listar();
    });
});
