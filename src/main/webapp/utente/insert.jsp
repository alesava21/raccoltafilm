<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="it" class="h-100">
<head>
	<meta charset="ISO-8859-1">
	<title>Inserisci utente</title>
	<jsp:include page="../header.jsp" />
</head>
<body class="d-flex flex-column h-100" style="background-color: #050402">
	<jsp:include page="../navbar.jsp"></jsp:include>
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none':'' }" role="alert">
					  ${errorMessage}
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
			  
			  <div class='card text-light' style="background-color: #050402">
				    <div class='card-header text-light' style="background-color: #050402">
				        <h5>Inserisci nuovo utente</h5> 
				    </div>
				    <div class='card-body'>
		
							<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>
		
		
							<form method="post" action="${pageContext.request.contextPath}/admin/ExecuteInsertUtenteServlet" class="row g-3" novalidate="novalidate">
							
							
								<div class="col-md-6">
									<label for="username" class="form-label">Username<span class="text-danger">*</span></label>
									<input type="text" name="username" id="username" class="form-control" placeholder="Inserire username" value="${insert_utente_attr.username}">
								</div>
								
								<div class="col-md-6">
									<label for="password" class="form-label">Password<span class="text-danger">*</span></label>
									<input type="password" name="password" id="password" class="form-control" placeholder="Inserire la password">
								</div>
							
								<div class="col-md-6">
									<label for="passwordConferma" class="form-label">Conferma password<span class="text-danger">*</span></label>
									<input type="password" name="passwordConferma" id="passwordConferma" class="form-control" placeholder="Inserire nuovamente la password">
								</div>
								
								<div class="col-md-6">
									<label for="nome" class="form-label">Nome<span class="text-danger">*</span></label>
									<input type="text" class="form-control" name="nome" id="nome" placeholder="Inserire il nome" value="${insert_utente_attr.nome}">
								</div>
								
								<div class="col-md-6">
									<label for="cognome" class="form-label">Cognome<span class="text-danger">*</span></label>
									<input type="text" class="form-control" name="cognome" id="cognome" placeholder="Inserire il cognome" value="${insert_utente_attr.cognome}">
								</div>
								
								<div class="col-md-6">
									<label for="ruoli" class="form-label">Ruoli<span class="text-danger">*</span></label>
									<c:forEach items="${ruoli_list_attribute}" var="ruoloItem">
										<div class="form-check">
  											<input class="form-check-input" type="checkbox" value="${ruoloItem.id}" id="flexCheckDefault" name="ruoli" 
  											<c:if test="${ruoli_assegnati.contains(ruoloItem.id)}">checked="checked"</c:if>>
  											<label class="form-check-label" for="flexCheckDefault">${ruoloItem.descrizione}</label>
										</div>
									</c:forEach>
								</div>
								
								<div class="col-12">
									<button type="submit" name="insertSubmit" value="insertSubmit" id="insertSubmit" class="btn btn-primary">Conferma</button>
								</div>
		
						</form>		   
				    </div>
				</div>
			  </div>
			  
			</main>
			<jsp:include page="../footer.jsp" />
</body>
</html>