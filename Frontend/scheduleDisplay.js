$(document).ready(function() {
    $('[data-toggle="tooltip"]').tooltip();
    console.log(courseDescriptions["EE302"])
    var num_of_schedules = 4;
    //placeholder JSON object
    var sem =
        '{ "semester" : 1, ' +
        '"courses": [' +
        '{ "courseName": "C1"}, {"courseName": "C2"}, {"courseName": "C3"}, {"courseName": "C4"}, {"courseName": "C5"} ]}';
    var obj = JSON.parse(sem);
    for (let schedule = 1; schedule <= num_of_schedules; schedule++) {
        //for each schedule
        for (let semester = 1; semester <= 8; semester++) {
            //for each semester in this schedule
            for (let coursenum = 2; coursenum <= 5; coursenum++) {
                //we need to put correct text for each course
                var current_element =
                    "s" + schedule + "sem" + semester + "c" + coursenum;
                $("#" + current_element).html(
                    obj.courses[coursenum - 1].courseName
                );
                $("#" + current_element).attr('data-original-title', courseDescriptions['EE302'])
            }
        }
    }
});