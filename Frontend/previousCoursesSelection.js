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
    for (i in M_courses) {
        var select = $("#coursePicker");
        course = M_courses[i];
        course_num = course.split(":")[0];
        courses[course_num] = { title: course, selected: false }
        opt = new Option(course, course_num);
        opt.setAttribute("data-tokens", course);
        select.append(opt);

        var searchTable = $("#searchTable")
        var row = $("<div>", { "class": "row", style: "cursor:pointer;" });
        var num = $("<div>", { "class": "col-sm-2 num" });
        num.append(course_num)
        var title = $("<div>", { "class": "col-sm-auto title" });
        title.append(course)
        var checkmark = $("<i>", { "class": "fa fa-check checkmark pull-right" }).hide();
        row.append(num)
        row.append(title)
        row.append(checkmark)
        searchTable.append(row)
    }
    for (i in EE_courses) {
        var select = $("#coursePicker");
        course = EE_courses[i];
        course_num = course.split(":")[0];
        courses[course_num] = { title: course, selected: false }
        opt = new Option(course, course_num);
        opt.setAttribute("data-tokens", course);
        select.append(opt);

        var searchTable = $("#searchTable")
        var row = $("<div>", { "class": "row", style: "cursor:pointer;" });
        var num = $("<div>", { "class": "col-sm-2 num" });
        num.append(course_num)
        var title = $("<div>", { "class": "col-sm-auto title" });
        title.append(course)
        var checkmark = $("<i>", { "class": "fa fa-check checkmark pull-right" }).hide();
        row.append(num)
        row.append(title)
        row.append(checkmark)
        searchTable.append(row)
    }
    for (i in PHY_courses) {
        var select = $("#coursePicker");
        course = PHY_courses[i];
        course_num = course.split(":")[0];
        courses[course_num] = { title: course, selected: false }
        opt = new Option(course, course_num);
        opt.setAttribute("data-tokens", course);
        select.append(opt);

        var searchTable = $("#searchTable")
        var row = $("<div>", { "class": "row", style: "cursor:pointer;" });
        var num = $("<div>", { "class": "col-sm-2 num" });
        num.append(course_num)
        var title = $("<div>", { "class": "col-sm-auto title" });
        title.append(course)
        var checkmark = $("<i>", { "class": "fa fa-check checkmark pull-right" }).hide();
        row.append(num)
        row.append(title)
        row.append(checkmark)
        searchTable.append(row)
    }
    $("#coursePicker")
        .children("option")
        .hide();
    $("#coursePicker option").each(function() {
        if (
            $(this)
            .val()
            .startsWith("EE")
        ) {
            $(this).show();
        }
    });
    $("#coursePicker").selectpicker("refresh");
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
            var num = $("<div>", { "class": "col-sm-auto display" });
            num.append(course_num)
            $("#selectedCourses").append(num);
        })
    });

    $("#coursePicker").change(function() {
        selectedCourses = [];
        document.getElementById("selectedCourses").innerHTML = "";

        $.each($("#searchTable .row:selected"), function() {
            selectedCourses.push($(this).val());
            var num = $("<div>", { "class": "col-sm-2 num" });
            num.append($(this).val())
            $("#selectedCourses").append(num);
        });
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
}); //end of ready function