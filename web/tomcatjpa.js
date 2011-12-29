/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function() {
                
    $.ajax({
        url: "http://localhost:8084/TomcatJpa/resources/pessoas",
        dataType: "json",
        success: function(data) {
            for (var i = 0; i < data.pessoa.length; i++) {
                $("#lista").append("<li>" + data.pessoa[i].nome + "</li>");
            }
        }
        
    });
});