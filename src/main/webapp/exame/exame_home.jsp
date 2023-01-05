<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title><s:text name="label.titulo.pagina.consulta"/></title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
	</head>
	<body >

    <nav class="navbar" style="background-color: #46A6AF;">
       <div class="container-fluid">
           <a class="navbar-brand" href="#" style="color: white">Soc - Desafio Tecnico</a>
           <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText"
           aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
               <span class="navbar-toggler-icon"></span>
           </button>

           <div class="collapse navbar-collapse" id="navbarText">
           <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                 <s:url action="todosExames" var="todos"/>
                 <a href="${todos}" class="nav-link active" style="color: white" >Exames</a>
              </li>
              <li class="nav-item">
                  <s:url action="ExameRealizado" var="todos"/>
                   <a href="${todos}" class="nav-link active" style="color: white" >Exames Realizados</a>
              </li>

              <li class="nav-item">
                <s:url action="todosFuncionarios" var="todos"/>
                <a href="${todos}" class="nav-link active" style="color: white" >Funcionarios</a>
              </li>
            </ul>
           </div>
       </div>
    </nav>

		<div class="container">
			<div class="row mt-5 mb-2">
				<div class="col-sm p-0">
					<s:form action="/filtrarExames.action">
						<div class="input-group">

								<s:select
									cssClass="form-select" 
									name="filtrar.opcoesCombo" 
									list="listaOpcoesCombo"  
									headerKey=""  
									headerValue="Escolha..." 
									listKey="%{codigo}" 
									listValueKey="%{descricao}"
									value="filtrar.opcoesCombo.codigo"									
								/>

								<s:textfield cssClass="form-control" id="nome" placeholder="Buscar por..." name="filtrar.valorBusca"/>
								<button class="btn btn-primary"  style="background-color: #46A6AF;color: white;type="submit"><s:text name="label.pesquisar"/></button>
						</div>
					</s:form>			
				</div>				
			</div>

			<div class="row mt-5 mb-2">
				<table class="table table-hover">
					<thead style="background-color: #46A6AF; color: white;">
						<tr>
							<th><s:text name="label.id"/></th>
							<th><s:text name="label.nome"/></th>
							<th class="text-end mt-5"><s:text name="label.acao"/></th>
						</tr>
					</thead>

					<tbody>
						<s:iterator value="exames" >
							<tr>
								<td>${codigoExame}</td>
								<td>${nome}</td>
								<td class="text-end">
									<s:url action="editarExames" var="editar">
										<s:param name="exameVo.codigoExame" value="codigoExame"></s:param>
									</s:url>

									<a href="${editar}" class="btn btn-warning text-white">
										<s:text name="label.editar"/>
									</a>
                                    <s:url action="excluirExames" var="excluir">
										<s:param name="exameVo.codigoExame" value="codigoExame"></s:param>
									</s:url>
									<a href="${excluir}" class="btn btn-danger"  >
										<s:text name="label.excluir"/>
									</a>
								</td>
							</tr>
						</s:iterator>
					</tbody>

				</table>

			</div>
                <s:url action="novoExames" var="novo"/>
                	<a href="${novo}" class="btn btn-success" style="background-color: #46A6AF; color: white;">
                		<s:text name="label.novo"/>
                </a>
			<div class="row">

			</div>
		</div>
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
	</body>
</html>