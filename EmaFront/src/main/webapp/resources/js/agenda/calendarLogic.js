

$(document).ready(function() {
    $(".starts-at, .ends-at").datetimepicker();
    $(".starts-at2, .ends-at2").datetimepicker();

    $('#calendar').fullCalendar({
    	contentHeight: 500,
    	locale: 'fr',
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,agendaWeek,agendaDay'
        },
        navLinks: true, // can click day/week names to navigate views
        selectable: true,
        selectHelper: true,
        select: function(start, end) {
            // Display the modal.
            // You could fill in the start and end fields based on the parameters
            $('#modal1').modal('show');
            $('#modal1').find('input').val('');
            $('#modal1').find('.starts-at').val(start);
            $('#modal1').find('.ends-at').val(end);
        },
        eventClick: function(event, element) {
            // Display the modal and set the values to the event values.
            $('#modal1').modal('show');
            $('#modal1').find('.name').val(event.title);
            $('#modal1').find('.starts-at').val(event.start);
            $('#modal1').find('.ends-at').val(event.end);
            
        },
        
        editable: true,
        eventLimit: true
       
    });
    $('.saveTask').on('click', function() {
    	
        var name = $('.name').val();
        if (name) {
        	event.title = name;
        	event.start = $('.starts-at').val();
        	event.end = $('.ends-at').val();
        	
            $('#calendar').fullCalendar('renderEvent', eventData, true); 
        }
        
        $('#calendar').fullCalendar('unselect');

        // Clear modal inputs
        $('#modal1').find('input').val('');

        // hide modal
        $('#modal1').modal('hide');
    });
});


$('#newObjectifButton').on('click', function() {

	$('#modal1').modal('hide');
	$('#modal2').modal('show');
	
});
