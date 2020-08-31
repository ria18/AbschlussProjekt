
// alert during the delete action 

var deleteLinks = document.querySelectorAll('#delete');

for (var i = 0; i < deleteLinks.length; i++) {
  deleteLinks[i].addEventListener('click', function(event) {
      event.preventDefault();
      var choice = confirm(this.getAttribute('data-confirm'));

      if (choice) {
        window.location.href = this.getAttribute('href');
      }
  });
}


// Alert when somthing will happend during crud operation 

$('#overlay').modal('show');

setTimeout(function() {
    $('#overlay').modal('hide');
}, 2000);

//solving the active menu problem
switch (menu) {

case 'Hauptseite':
	$('#home').addClass('active');
	break;
case 'Lizenz Verwalten':
	$('#manage').addClass('active');
	break;
	
default:
	$('#home').addClass('active');
	
	break;
}



// // Handling checkBox work 
//id_numbers = new Array();
$(document).ready(function(){
		
        $('input[type="checkbox"]').click(function(){

            if($(this).prop("checked") == true){
				
                var columns = $(this).closest('tr').find('td:not(:first-child)');
                
                var aColumns = new Array();
               
      	      $(columns).each(function(index) {
//      	        console.log("Column " + (index + 1) + " has value " + $(this).text());
      	      aColumns[index + 1] = $(this).text();
      	     
      	      });
      	      
      	      // console.log("1=" + aColumns[1] + " 2=" + aColumns[2]);
      	      
	      	    $.ajax({
	      		   type:'GET',
	      		   url :"/AbschlussProjekt/result",
	      		   data:{lizenzName: aColumns[1], lizenzKey: aColumns[2]},
	      		   success: function(data) {
	      		        console.log('success',data);
	      		   },
	      		   error:function(exception){alert('Exeption:'+exception);}
	      		});
      	      
      	      
            }

            else if($(this).prop("checked") == false){

               console.log("Checkbox is unchecked.");
      

            }

        });

    });

