<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    ${projeto.nome} <br>
    ${projeto.descricao}<br>
    ${projeto.dataInicio}<br>
    ${projeto.dataPrevisaoTermino}<br>
    ${projeto.dataRealTermino}<br>
    ${projeto.orcamentoTotal}<br>
    ${projeto.gerenteResponsavel.nome}<br>
    ${projeto.empresa.nome}<br>
    ${projeto.risco}<br>
    ${projeto.status}<br>

    <h2>Confirmar Deleção</h2>
    <p>Tem certeza que deseja deletar o projeto <strong>${projeto.nome}</strong>?</p>
    <form method="post" action="/projetos/${projeto.id}/deletar">
        <input type="hidden" name="_method" value="PUT">
        <button type="submit" class="btn btn-danger">Deletar</button>
        <a href="/projetos" class="btn btn-secondary">Cancelar</a>
    </form>
</body>
</html>