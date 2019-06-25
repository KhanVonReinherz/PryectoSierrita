
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="pe.kamwha.dao.impl.CategoriaDaoImpl"%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Reporte de Reservas  Mensuales || Chifa Kam Wha</title>
  <link rel="stylesheet" href="css/StyleHome.css">
  <script src="js/Homejquery.js"></script>
  <script src="js/Homejquery.knob.js"></script>
  <script>
    $(document).ready(function() {
      //$(".dial").knob();
      $('.dial').knob({
        'min':0,
        'max':100,
        'width':'120%',
        'height':'120%',
        'displayInput':true,
        'fgColor':"#FFF",
        'release':function(v) {$("p").text(v);},
        'readOnly':true
      });
    });
  </script>
</head>
<body>
    <%String  num="50"; String  num2="80"; String num3="0";String  num4="80";String  num5="80";String  numJ="0";
    CategoriaDaoImpl cat = new CategoriaDaoImpl();
    try{
    List<String> lista= cat.listarReporteVentas();
    num=lista.get(0) ;num2= lista.get(1);num3=lista.get(2);num4= lista.get(3);num5=lista.get(4);numJ= lista.get(5);
    }catch(Exception e){
    System.out.println("Error Puto: "+e.getMessage());
    }
  
   %>
 
        <div class="center">
          <h2>Reservas Esperadas</h2>
          <div class="Grafico">
             <input type="text" value="<%=numJ%>" class="dial" data-width="200" 
              data-thickness=".35" data-fgColor="#008BE8" data-bgColor="#222" 
              data-cursor=false data-displayInput="true" data-readOnly=true >
           </div>
           <div class="skillBox">
               <p>Marzo</p>
               <p><%=num %></p>
               <div class="skill">
                   <div class="skill_level" style="width:<%=num%>"></div>
               </div>
           </div>
            <div class="skillBox">
               <p>Abril</p>
               <p><%=num2 %></p>
               <div class="skill">
                   <div class="skill_level" style="width:<%=num2%>"></div>
               </div>
           </div>
            <div class="skillBox">
               <p>Mayo</p>
               <p><%=num3 %></p>
               <div class="skill">
                   <div class="skill_level" style="width:<%=num3%>"></div>
               </div>
           </div>
            <div class="skillBox">
               <p>Junio</p>
               <p><%=num4 %></p>
               <div class="skill">
                   <div class="skill_level" style="width:<%=num4%>"></div>
               </div>
           </div>
               <div class="skillBox">
               <p>Julio</p>
               <p><%=num5%></p>
               <div class="skill">
                   <div class="skill_level" style="width:<%=num5%>"></div>
               </div>
           </div>
     
          <div class="Indicaciones">
              <ul class="menu">
                  <li>No Se cumplió Reservas Esperada : Marzo</li>
                  <li>No Se cumplió Reservas Esperada :Abril</li>
                  <li>No Se cumplió Reservas Esperada :Mayo</li>
                  <li>No Se cumplió Reservas Esperada :Junio</li>
                  <li>No Se cumplió Reservas Esperada Julio</li>
              </ul>
          </div>
           </div>       
</body>
</html>