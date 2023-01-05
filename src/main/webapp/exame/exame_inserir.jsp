<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title><s:text name="label.titulo.pagina.cadastro"/></title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
             integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
            </head>
        <body>

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

         <figure class="text-center">
            <blockquote class="blockquote">
              <h1  style="color: #46A6AF;">Novo Exame</h1 >
            </blockquote>

         </figure>

			<s:form action="/novoExames.action">

				<div class="card">
				 <img class="  rounded mx-auto d-block"
                          src="data:image/png;base64,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"
                          class="img-fluid" alt="Responsive image">

					<div class="card-body">
						<div class="row align-items-center">
							<label for="id" class="col-sm-1 col-form-label text-center">
								Codigo:
							</label>	

							<div class="col-sm-2">
								<s:textfield cssClass="form-control" id="id" name="exameVo.codigoExame" readonly="true"/>
							</div>	
						</div>
						
						<div class="row align-items-center mt-3">
							<label for="nome" class="col-sm-1 col-form-label text-center">
								Nome:
							</label>	

							<div class="col-sm-5">
								<s:textfield cssClass="form-control" id="nome" name="exameVo.nome"/>							
							</div>	
						</div>
					</div>

					<div class="row mt-5 mb-2">
						<div class="form-row">
							<button class="btn btn-primary col-sm-4 offset-sm-1">Salvar</button>
							<button type="reset" class="btn btn-secondary col-sm-4 offset-sm-2">Limpar Formulario</button>
						</div>
					</div>
				</div>
			</s:form>			
		</div>
		
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
	</body>
</html>