<!doctype html>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Ricerca Utenti</title>
	 </head>
	   <body class="d-flex flex-column h-100" style="background-color: #050402">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none':'' }" role="alert">
					  ${errorMessage}
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
			  
			  <div class='card text-light' style="background-color: #050402">
				    <div class='card-header text-light' style="background-color: #050402">
				        <h5>Ricerca utenti</h5> 
				    </div>
				    <div class='card-body'>
		
							<form method="post" action="ExecuteSearchUtentiServlet" class="row g-3" >
							
								<div class="col-md-6">
									<label for="username" class="form-label">Username </label>
									<input type="text" class="form-control" name="username" id="username" placeholder="Inserire il nickname"  >
								</div>
								<div class="col-md-6">
									<label for="nome" class="form-label">Nome </label>
									<input type="text" name="nome" id="nome" class="form-control" placeholder="Inserire il nome"  >
								</div>
								
								<div class="col-md-6">
									<label for="cognome" class="form-label">Cognome </label>
									<input type="text" name="cognome" id="cognome" class="form-control" placeholder="Inserire il cognome"  >
								</div>
								
								<div class="col-md-3">
									<label for="dateCreated" class="form-label">Data Creazione </label>
                        			<input class="form-control" id="dateCreated" type="date" placeholder="dd/MM/yy"
                            			title="formato : gg/mm/aaaa"  name="dateCreated"   >
								</div>
								
								
							<div class="col-12">
								<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
								<a class="btn btn-outline-primary ml-2" href="${pageContext.request.contextPath}/admin/PrepareInsertUtenteServlet">Add New</a>
								<input class="btn btn-outline-warning" type="reset" value="Ripulisci">
							</div>
							</form>
					    </div>
		

  
				    
				    
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