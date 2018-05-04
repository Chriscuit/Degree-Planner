$(document).ready(function() {
    $('[data-toggle="tooltip"]').tooltip();

    for (var i = 0; i < test_plan.numSemesters; i++) {
        var col = $("<div>", { "class": "col", id: "sem" + i })
        var header = $("<div>", { "class": "header" })
        header.append("Semester " + (i + 1))
        col.append(header)
        if (i % 2 == 0) {
            $("#row1").append(col)
        } else {
            $("#row2").append(col)
        }
    }
    for (var i = 0; i < test_plan.numSemesters; i++) {
        var current = test_plan.JsonSemester[i]
        for (j in current.courses) {
            var matches = current.courses[j].match(/([a-zA-Z]*)([0-9\.]+)/);
            var dept = ""
            console.log(matches)
            if (matches) {
                dept = matches[1].toLowerCase()
            }
            var num = $("<div>", { "class": ("col-sm num " + dept) })
            num.append(current.courses[j])
            var difficulty = $("<div>", { "class": "col-sm" });

            var found = course_info.courses.find(function(element) {
                return element.title === current.courses[j];
            });
            var difficulty_rating = 1
            if (found) {
                difficulty_rating = found.difficulty
            }

            for (var k = 0; k < difficulty_rating; k++) {
                var dot = $("<i>", { "class": "fa fa-circle" })

                difficulty.append(dot)
            }
            var col = $("#sem" + i)
            var row = $("<div>", { "class": "row" })
            row.append(num)
            row.append(difficulty)
            col.append(row)

        }

    }
    //placeholder JSON object
    // var sem =
    //     '{ "semester" : 1, ' +
    //     '"courses": [' +
    //     '{ "courseName": "C1"}, {"courseName": "C2"}, {"courseName": "C3"}, {"courseName": "C4"}, {"courseName": "C5"} ]}';
    // var obj = JSON.parse(sem);
    // for (let schedule = 1; schedule <= num_of_schedules; schedule++) {
    //     //for each schedule
    //     for (let semester = 1; semester <= 8; semester++) {
    //         //for each semester in this schedule
    //         for (let coursenum = 2; coursenum <= 5; coursenum++) {
    //             //we need to put correct text for each course
    //             var current_element =
    //                 "s" + schedule + "sem" + semester + "c" + coursenum;
    //             $("#" + current_element).html(
    //                 obj.courses[coursenum - 1].courseName
    //             );
    //             $("#" + current_element).attr('data-original-title', courseDescriptions['EE302'])
    //         }
    //     }
    // }
});