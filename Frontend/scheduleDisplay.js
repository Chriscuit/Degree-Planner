$(document).ready(function() {

    var num_cols = Math.ceil(test_plan.numSemesters / 2)
    for (var i = 0; i < num_cols; i++) {
        var row_id = i * 2
        var col = $("<div>", { "class": "col yearly", id: "year" + i })
        var row1 = $("<div>", { "class": "row", id: "row" + row_id })
        var row2 = $("<div>", { "class": "row", id: "row" + (row_id + 1) })

        col.append(row1)
        col.append(row2)
        $("#scheduleRow").append(col)

    }

    for (var i = 0; i < test_plan.numSemesters; i++) {
        var col = $("<div>", { "class": "col sem", id: "sem" + i })
        var header = $("<div>", { "class": "header" })
        header.append("Semester " + (i + 1))
        col.append(header)
        $("#row" + i).append(col)

        var current = test_plan.JsonSemester[i]
        for (j in current.courses) {
            var matches = current.courses[j].match(/([a-zA-Z]*)([0-9\.]+)/);
            var dept = ""
            if (matches) {
                dept = matches[1].toLowerCase()
            }
            var num = $("<div>", { "class": ("col-sm num " + dept) })
            num.append(current.courses[j])
            var title = courseDescriptions[current.courses[j]]
            console.log(title)
            num.attr('data-toggle', 'tooltip');
            num.attr('title', title);
            num.tooltip({})
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

        for (var num = current.courses.length; num < 6; num++) {
            var row_hide = $("<div>", { "class": "row hide" })
            var num_hide = $("<div>", { "class": ("col-sm num ") })
            num_hide.append("EE302")
            var difficulty_hide = $("<div>", { "class": "col-sm" });

            difficulty_hide.append($("<i>", { "class": "fa fa-circle" }))

            row_hide.append(num_hide)
            row_hide.append(difficulty_hide)
            col.append(row_hide)
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