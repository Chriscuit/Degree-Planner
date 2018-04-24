var selectedCourses = [];
var hoursSlider = $("#hoursSlider")
	.slider()
	.data("slider");

var difficultySlider = $("#difficultySlider")
	.slider()
	.data("slider");

$(document).ready(function() {
	var math_courses = ["M1", "M2", "M3"];
	$("#test").hide();

	$("#departmentCoursesButton").on("click", function() {
		var departmentPicker = document.getElementById("departmentPicker");
		var department =
			departmentPicker.options[departmentPicker.selectedIndex].value;
		if (department === "Mathematics") {
			$("#test").show();
			var select = document.getElementById("coursePicker");
			for (i = 0; i < 10; i++) {
				select.options[select.options.length] = new Option(
					"Text " + i,
					"Value " + i
				);
			}
			$("#coursePicker").selectpicker("refresh");
		}
	}); //end of department button on click function

	$("#addCourse").on("click", function() {
		alert(selectedCourses.join(","));
		// var span = document.createElement('span')
		// span.innerText = ;
		// $("#selectedCourses").add(span)
	}); //end of add button on click function

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
