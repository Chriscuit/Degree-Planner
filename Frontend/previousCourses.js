var selectedCourses = [];
var hoursSlider = $("#hoursSlider")
	.slider()
	.data("slider");

var difficultySlider = $("#difficultySlider")
	.slider()
	.data("slider");

$(document).ready(function() {
	$("#test").hide();
	for (i in M_courses) {
		var select = $("#coursePicker");
		course = M_courses[i];
		course_num = course.split(":")[0];
		opt = new Option(course, course_num);
		opt.setAttribute("data-tokens", course);
		select.append(opt);
	}
	for (i in EE_courses) {
		var select = $("#coursePicker");
		course = EE_courses[i];
		course_num = course.split(":")[0];
		opt = new Option(course, course_num);
		opt.setAttribute("data-tokens", course);
		select.append(opt);
	}
	for (i in PHY_courses) {
		var select = $("#coursePicker");
		course = PHY_courses[i];
		course_num = course.split(":")[0];
		opt = new Option(course, course_num);
		opt.setAttribute("data-tokens", course);
		select.append(opt);
	}

	$("#departmentPicker").change(function() {
		$("#coursePicker")
			.children("option")
			.hide();

		$("#test").show();
		var departmentPicker = document.getElementById("departmentPicker");
		var department =
			departmentPicker.options[departmentPicker.selectedIndex].value;
		var select = $("#coursePicker");
		if (department === "Mathematics") {
			$("#coursePicker option").each(function() {
				if (
					$(this)
						.val()
						.startsWith("M")
				) {
					$(this).show();
				}
			});
			$("#coursePicker").selectpicker("refresh");
		} else if (department === "Electrical Engineering") {
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
		} else {
			$("#coursePicker option").each(function() {
				if (
					$(this)
						.val()
						.startsWith("PHY")
				) {
					$(this).show();
				}
			});
			$("#coursePicker").selectpicker("refresh");
		}
	});

	$("#coursePicker").change(function() {
		selectedCourses = [];
		document.getElementById("selectedCourses").innerHTML = "";

		$.each($("#coursePicker option:selected"), function() {
			selectedCourses.push($(this).val());
			var para = document.createElement("P"); // Create a <p> node
			var t = document.createTextNode($(this).val()); // Create a text node
			para.appendChild(t); // Append the text to <p>
			document.getElementById("selectedCourses").appendChild(para); // Append <p> to <div> with id="myDIV"
		});
	});

	// Placeholder for function that sends data to backend
	$("#displayTimeDifficulty").on("click", function() {
		var toSend = {};
		toSend.selectedCourses = selectedCourses;
		// toSend.primaryCore = sessionStorage.primaryCore;
		// toSend.secondaryCore = sessionStorage.secondaryCore;
		// toSend.anchorCoursesPrimary = sessionStorage.anchorCoursesPrimary;
		// toSend.anchorCoursesSecondary = sessionStorage.anchorCoursesSecondary;
		toSend.maxHours = hoursSlider.getValue();
		toSend.difficulty = difficultySlider.getValue();
		console.log(toSend);
	}); //end of add button on click function
}); //end of ready function
