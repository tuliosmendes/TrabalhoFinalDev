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
	
	
	
	$scope.salvar = function() {
		if (isValidSave()) {
			var urlSalvarCurso = urlPadrao + "rs/aluno/";
			var param = $scope.aluno;
			param.curso = $scope.selected;
			salvarAluno(urlSalvarCurso, param);
		}
	}
	
	function isValidSave() {
		var valido = true;
		$scope.mensagens = [];
		
		if ($scope.aluno == undefined) {
			$scope.mensagens.push('Preencha o nome');
			$scope.mensagens.push('Preencha o sexo');
			valido = false;
		}
		
		if ($scope.aluno != undefined && $scope.aluno.nome == undefined) {			
			$scope.mensagens.push('Preencha o nome');
			valido = false;
		}
		
		if ($scope.aluno != undefined && $scope.aluno.sexo == undefined) {			
			$scope.mensagens.push('Preencha o sexo');
			valido = false;
		}
		
		if ($scope.selected == undefined) {			
			$scope.mensagens.push('Preencha o curso');
			valido = false;
		}
		
		return valido;
	}
	
	function salvarAluno(urlSalvarAluno, obj) {
		 $.ajax({
		  type : 'POST',
		  contentType : 'application/json',
		  url : urlSalvarAluno,
		  dataType : "json",
		  data : JSON.stringify(obj),
		  success : callbackSucessSave,
		  error : function(jqXHR, textStatus, errorThrown) {
			  alert('Erro ao salvar aluno: ' + jqXHR.responseText);
		  }
		 });
	}
	
	function callbackSucessSave() {
		$scope.mensagens = [];
		$scope.mensagens.push('Aluno salvo com sucesso!');
		$scope.buscarAlunos();
		limpar();
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
				 $scope.mensagens = [];
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
	
	function limpar() {
		$scope.aluno = {};
		$scope.selected = undefined;
	}
	
	$scope.carregarCursos();
	$scope.buscarAlunos();

});
