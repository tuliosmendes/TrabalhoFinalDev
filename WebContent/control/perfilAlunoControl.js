var app = angular.module('perfilAlunoModule',[]);

app.controller('perfilAlunoControl',function($scope,$http){
	
	$scope.mensagens = [];
	$scope.perfilAluno = {};
	$scope.perfilAluno.aluno = {};
	$scope.perfilAluno.aluno.curso = {};
	
	var urlPadrao = "http://localhost:8080/perfil-alunos-ti-iftm/";

	
	var urlBuscarAlunos = urlPadrao + "rs/aluno";
	
	$scope.buscarAlunos = function(){
		 $http.get(urlBuscarAlunos).success(function (alunosRetorno) {
			 $scope.alunos = alunosRetorno;
		 }).error(function(mensagemErro) {
			 alert(mensagemErro);
		 });
	}
	
	var urlBuscarAreas = urlPadrao + "rs/area";
	
	$scope.buscarAreas = function(){
		 $http.get(urlBuscarAreas).success(function (areasRetorno) {
			 $scope.areas = areasRetorno;
		 }).error(function(mensagemErro) {
			 alert(mensagemErro);
		 });
	}


	var urlBuscarPerfilAlunos = urlPadrao + "rs/perfilAluno";
	
	$scope.buscarPerfilAlunos = function(){
		 $http.get(urlBuscarPerfilAlunos).success(function (perfilAlunosRetorno) {
			 $scope.perfilAlunos = perfilAlunosRetorno;
		 }).error(function(mensagemErro) {
			 alert(mensagemErro);
		 });
	}
	
	$scope.novo = function(){
		$scope.alunos = {};
		$scope.perfilAlunos = {};
		$scope.perfilAluno = {};
		$scope.mensagens = [];
		$scope.selected = undefined;
		$scope.selectedArea = undefined;
		$scope.buscarAlunos();
	}
	
	function limpar() {
		$scope.perfilAluno = {};
		$scope.selected = undefined;
		$scope.selectedArea = undefined;
	}
	
	$scope.salvar = function() {
		if (isValidSave()) {
			var urlSalvarPerfilAluno = urlPadrao + "rs/perfilAluno/";
			var param = $scope.perfilAluno;
			param.area = $scope.selectedArea;
			param.aluno = $scope.selected;
			salvarPerfilAluno(urlSalvarPerfilAluno, param);
		}
	}
	
	function isValidSave() {
		var valido = true;
		$scope.mensagens = [];
		
		if ($scope.selected == undefined) {			
			$scope.mensagens.push('Selecione o Aluno');
			valido = false;
		}
		
		if ($scope.perfilAluno != null && $scope.perfilAluno.trabalhaNaArea == undefined) {
			$scope.mensagens.push('Marque a opcao Trabalha na area');
			valido = false;
		}
		
		if ($scope.perfilAluno != null && $scope.perfilAluno.trabalhaNaArea == 'true') {
			if ($scope.selectedArea ==  undefined) {				
				$scope.mensagens.push('Selecione a Area');
				valido = false;
			}
		}
		
		if ($scope.perfilAluno != null && $scope.perfilAluno.objetivoCurso == undefined) {
			$scope.mensagens.push('Preencha o Objetivo do Curso');
			valido = false;
		}
		
		return valido;
	}
	
	function salvarPerfilAluno(urlSalvarPerfilAluno, obj) {
		 $.ajax({
		  type : 'POST',
		  contentType : 'application/json',
		  url : urlSalvarPerfilAluno,
		  dataType : "json",
		  data : JSON.stringify(obj),
		  success : callbackSucessSave,
		  error : function(jqXHR, textStatus, errorThrown) {
			  alert('Erro ao salvar perfil aluno: ' + jqXHR.responseText);
		  }
		 });
	}
	
	function callbackSucessSave() {
		$scope.mensagens = [];
		$scope.mensagens.push('Perfil Aluno salvo com sucesso!');
		$scope.buscarPerfilAlunos();
		limpar();
	}
	
	$scope.pesquisar = function(){
		var param = $scope.selected.codigo;
		var urlPesquisarPerfilAluno = urlPadrao + "rs/perfilAluno/" + param;
		
		 $http.get(urlPesquisarPerfilAluno).success(function (perfilAlunoRetorno) {
			 if (perfilAlunoRetorno.length == 0) {
				 $scope.mensagens.push('Nao encontrado registros para sua busca');
			 } else {
				 $scope.perfilAluno = perfilAlunoRetorno;
				 
				 var indice = $scope.perfilAluno.area.codigo - 1;
				 $scope.selectedArea = $scope.areas[indice];
				 
				 $scope.mensagens = [];
			 }
			 
		 }).error(function(mensagemErro) {
			 alert(mensagemErro);
		 });
	}
	
	$scope.buscarAlunos();
	$scope.buscarAreas();
	$scope.buscarPerfilAlunos();
	
	$scope.onChangeAluno = function () {
		$scope.perfilAluno.aluno.curso.nome = $scope.selected.curso.nome;
	};
	
});
