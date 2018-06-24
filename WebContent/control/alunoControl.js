var app = angular.module('alunoModule',[]);

app.controller('alunoControl',function($scope,$http){
	
	$scope.mensagens = [];
	
	var urlPadrao = "http://localhost:8080/perfil-alunos-ti-iftm/";
	
	var urlAllCursos = urlPadrao + "rs/curso";
	
	$scope.carregarCursos = function(){
		 $http.get(urlAllCursos).success(function (cursosRetorno) {
			 $scope.cursos = cursosRetorno;
		 }).error(function(mensagemErro) {
			 alert(mensagemErro);
		 });
	}
	
	var urlSalvarCurso = urlPadrao + "rs/aluno/";
	
	$scope.salvar = function() {
/*		 $http.post(urlSalvarCurso).success(function (cursosRetorno) {
			 $scope.cursos = cursosRetorno;
		 }).error(function(mensagemErro) {
			 alert(mensagemErro);
		 });
		 */
    	$scope.alunos.push($scope.aluno);
		$scope.novo();
		$scope.mensagens.push('Aluno salvo com sucesso!');
	}
	
	var urlBuscarAlunos = urlPadrao + "rs/aluno";
	
	$scope.buscarAlunos = function(){
		 $http.get(urlBuscarAlunos).success(function (alunosRetorno) {
			 $scope.alunos = alunosRetorno;
		 }).error(function(mensagemErro) {
			 alert(mensagemErro);
		 });
	}
	
	
	
	
	$scope.pesquisar = function(){
		var param = $scope.aluno.nome;
		var urlPesquisarAluno = urlPadrao + "rs/aluno/getnome/" + param;
		
		 $http.get(urlPesquisarAluno).success(function (alunosRetorno) {
			 if (alunosRetorno.length == 0) {
				 $scope.mensagens.push('Nao encontrado registros para sua busca');
			 } else {
				 $scope.aluno = alunosRetorno[0];
				 var indice = $scope.aluno.codigo - 1;
				 $scope.selected = $scope.cursos[indice];
				 $scope.mensagens = [];
			 }
			 
		 }).error(function(mensagemErro) {
			 alert(mensagemErro);
		 });
	}
	
	$scope.novo = function(){
		$scope.aluno = {};
		$scope.mensagens = [];
		$scope.selected = undefined;
	}
	
	$scope.carregarCursos();
	$scope.buscarAlunos();
	
	/*var url = "http://localhost:8080/ExtensaoServer/rs/pessoa";
	
	$scope.pesquisar = function(){
		 $http.get(url).success(function (pessoasRetorno) {
			 $scope.pessoas = pessoasRetorno;
		 }).error(function(mensagemErro) {
			 alert(mensagemErro);
		 });
	}
	
	$scope.novo = function(){
		$scope.pessoa = {};
		$scope.pessoa.telefones = [];
		$scope.mensagens = [];
	}
	
	$scope.montaMensagemErro = function(listaErro) {
		$scope.mensagens = [];
		$scope.mensagens.push('Falha de validação retornada do servidor');
		angular.forEach(listaErro, function(value, key){
			 $scope.mensagens.push(value.message);
		});
	}

    $scope.salvar = function() {    	
    	$scope.pessoas.push($scope.pessoa);
		$scope.novo();
		$scope.mensagens.push('pessoa salvo com sucesso');
	}
	
	$scope.excluir = function() {
		if ($scope.pessoa.codigo == '') {
			alert('Selecione um pessoa');
		} else {
			$scope.pessoas.splice($scope.pessoas.indexOf($scope.pessoa),1);
			$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('pessoa excluído com sucesso');
		}
	}
	
	$scope.seleciona = function(pessoaTabela) {
		$scope.pessoa = pessoaTabela;
	}
	
	$scope.pesquisar();
	$scope.novo();*/
});
