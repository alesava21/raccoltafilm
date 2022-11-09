<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Pagina dei Risultati</title>
	 </head>
	 
	<body class="d-flex flex-column h-100" style="background-color: #050402">
	 
		<!-- Fixed navbar -->
		<jsp:include page="../navbar.jsp"></jsp:include>
	 
	
		<!-- Begin page content -->
		<main class="flex-shrink-0">
		  <div class="container">
		  
		  		<div class="alert alert-success alert-dismissible fade show  ${successMessage==null?'d-none':'' }" role="alert">
				  ${successMessage}
				  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
				</div>
				<div class="alert alert-danger alert-dismissible fade show d-none" role="alert">
				  Esempio di operazione fallita!
				  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
				</div>
				<div class="alert alert-info alert-dismissible fade show d-none" role="alert">
				  Aggiungere d-none nelle class per non far apparire
				   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
				</div>
		  
		  
		  
		  		<div class='card text-light' style="background-color: #050402">
				    <div class='card-header text-light' style="background-color: #050402">
				        <h5>Lista dei risultati</h5> 
				    </div>
				    <div class='card-body text-light'>
				    	<!--  <a class="btn btn-primary " href="#">Add New</a>-->
				    
				        <div class='table-responsive text-light'>
				            <table class='table text-light ' >
				                <thead>
				                    <tr>
				                   		<th>Username</th>
			                         	<th>Nome</th>
				                        <th>Cognome</th>
				                        <th>Data di Creazione</th>
				                    </tr>
				                </thead>
				                <tbody>
								<c:forEach items="${utenti_list_attribute }" var="utenteItem">
									<tr>
										<td>${utenteItem.username }</td>
										<td>${utenteItem.nome }</td>
										<td>${utenteItem.cognome }</td>
										<td><fmt:formatDate type="date"
												value="${utenteItem.dateCreated }" /></td>

									</tr>
								</c:forEach>
							</tbody>
				            </table>
				        </div>
				        <div class='card-footer'>
					        <a href="PrepareSearchUtentiServlet" class='btn btn-outline-secondary' style='width:80px'>
					            <i class='fa fa-chevron-left'></i> Back
					        </a>
				   
					<!-- end card-body -->			   
			    </div>
			<!-- end card -->
			</div>	
		 
		   
		 <!-- end container -->  
		  </div>
		  
		</main>
		
		<!-- Footer -->
		<jsp:include page="../footer.jsp" />
		
	</body>
</html>