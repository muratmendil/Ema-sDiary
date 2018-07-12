<script>
$(document).ready(function() {
    $("#starts-at, #ends-at").datetimepicker();

    $('#calendar').fullCalendar({
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
            $('#modal1').find('#starts-at').val(start);
            $('#modal1').find('#ends-at').val(end);
            var name = $('#name').val();
            if (name) {
                var eventData = {
                    title: name,
                    start: start,
                    end: end
                };
                $('#calendar').fullCalendar('renderEvent', eventData, true); // stick? = true
            }
        },
        eventClick: function(start, end, event, element) {
            // Display the modal and set the values to the event values.
            $('#modal1').modal('show');
            $('#modal1').find('#name').val(event.name);
            $('#modal1').find('#starts-at').val(event.start);
            $('#modal1').find('#ends-at').val(event.end);
            
            var name = $('#name').val();
            if (name) {
                var eventData = {
                    title: name,
                    start: $('#starts-at').val(),
                    end: $('#ends-at').val()
                };
                $('#calendar').fullCalendar('renderEvent', eventData, true); // stick? = true
            }
            $('#calendar').fullCalendar('unselect');

            // Clear modal inputs
            $('#modal1').find('input').val('');

            // hide modal
            $('#modal1').modal('hide');

        },
        editable: true,
        eventLimit: true
       
    });
});
</script>
