var selectedCourses = [];
var courses = {};
// var hoursSlider = $("#hoursSlider")
//     .slider()
//     .data("slider");

// var difficultySlider = $("#difficultySlider")
//     .slider()
//     .data("slider");

$(document).ready(function() {
    console.log(JSON.parse(sessionStorage.getItem("pCourses")))
    console.log(sessionStorage.sCourses)
    addCourses(M_courses, "m")
    addCourses(EE_courses, "ee")

    addCourses(PHY_courses, "phy")
    addCourses(GOV_courses, "gov")

    function addCourses(current_courses, dept) {
        for (i in current_courses) {
            course = current_courses[i];
            course_num = course.split(":")[0];
            courses[course_num] = { title: course, selected: false }

            var searchTable = $("#searchTable")
            var row = $("<div>", { "class": "row course", style: "cursor:pointer; border-radius:8px;" });
            var num = $("<div>", { "class": "col-sm-2 num " + dept });
            num.append(course_num)
            var title = $("<div>", { "class": "col-sm-auto title" });
            title.append(course.split(":")[1])
            var checkmark = $("<i>", { "class": "fa fa-check checkmark pull-right" }).hide();
            row.append(num)
            row.append(title)
            row.append(checkmark)
            searchTable.append(row)
        }
    }

    filterDept()

    $("#departmentPicker").change(function() {
        $("#searchTable")
            .children(".row")
            .hide();

        var departmentPicker = document.getElementById("departmentPicker");
        var department =
            departmentPicker.options[departmentPicker.selectedIndex].value;
        var select = $("#coursePicker");
        filterDept()
        $("#coursePicker").selectpicker("refresh");
    });

    $("#searchTable .row").click(function() {
        selectedCourses = [];
        document.getElementById("selectedCourses").innerHTML = "";
        courses[$(this).children(".num")
            .text()].selected = !courses[$(this).children(".num")
            .text()].selected;
        if (courses[$(this).children(".num").text()].selected) {
            $(this).children(".checkmark").show()
        } else {
            $(this).children(".checkmark").hide()
        }
        Object.keys(courses).filter((course_num) => (courses[course_num].selected)).forEach((course_num) => {
            selectedCourses.push(course_num);
            var num = $("<div>", { "class": "col-sm-auto display " + getDept(course_num) });
            num.append(course_num)
            $("#selectedCourses").append(num);
        })
    });


    Array.prototype.diff = function(a) {
        return this.filter(function(i) { return a.indexOf(i) < 0; });
    };

    function filterDept() {
        var dept = $("#departmentPicker").val()
        var searchDept = "M"
        if (dept === "Electrical Engineering") {
            searchDept = "EE"
        }
        if (dept === "Physics") {
            searchDept = "PHY"
        }
        if (dept == "Government") {
            searchDept = "GOV"
        }
        $("#searchTable .row").each(function() {
            console.log($(this).children(".num").text())
            if (
                $(this).children(".num")
                .text()
                .startsWith(searchDept) && ($(this).children(".num")
                    .text().toLowerCase()
                    .indexOf($("#searchBox").val().toLowerCase()) > -1 || $(this).children(".title")
                    .text().toLowerCase()
                    .indexOf($("#searchBox").val().toLowerCase()) > -1)
            ) {
                $(this).show();
            } else {
                $(this).hide();
            }
        });
    }

    $("#searchBox").keyup(function() {
        // console.log($("#searchBox").val())
        filterDept()
    });

    function getDept(course_num) {
        var matches = course_num.match(/([a-zA-Z]*)([0-9\.]+)/);
        var dept = ""
        if (matches) {
            dept = matches[1].toLowerCase()
        }
        return dept
    }


    $(document).on('click', '.display', function() {
        selectedCourses = [];
        var elem = courses[$(this).text()]
        elem.selected = !elem.selected
        var row = $('#searchTable .row:contains("' + $(this).text() + '")')
        console.log(row)
        if (elem.selected) {
            row.children(".checkmark").show()
        } else {
            row.children(".checkmark").hide()
        }
        var index = selectedCourses.indexOf($(this).text());
        if (index > -1) {
            array.splice(index, 1);
        }
        $(this).remove()
        // Object.keys(courses).filter((course_num) => (courses[course_num].selected)).forEach((course_num) => {
        //     selectedCourses.push(course_num);
        //     var num = $("<div>", { "class": "col-sm-auto display " + getDept(course_num) });
        //     num.append(course_num)
        //     $("#selectedCourses").append(num);
        // })
    });

    // Placeholder for function that sends data to backend
    $("#displayTimeDifficulty").on("click", function() {
        var toSend = {};

        var courseList = required_courses;
        var pCourses = JSON.parse(sessionStorage.getItem("pCourses"))
        var sCourses = JSON.parse(sessionStorage.getItem("sCourses"))
        courseList = courseList.concat(pCourses)
        courseList = courseList.concat(sCourses)
        toSend.courseList = courseList.diff(selectedCourses)
        // toSend.primaryCore = sessionStorage.primaryCore;
        //toSend.maxHours = hoursSlider.getValue();
        //toSend.difficulty = difficultySlider.getValue();
        console.log(toSend);
    }); //end of add button on click function

    $('#clear').on('click', function() {
        $("#searchBox").val("");
        console.log('cleared')
        filterDept()
    })

}); //end of ready function