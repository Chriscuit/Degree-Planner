var courseDescriptions = {
    EE302: "The scope and nature of professional activities of electrical engineers, including problem-solving techniques; analysis and design methods; engineering professional ethics; analysis of analog resistive circuits, including Thevenin/Norton equivalents, mesh analysis, and nodal analysis; and operational amplifiers (DC response). Electrical Engineering 302 and 302H may not both be counted.",

    EE306: "Motivated, bottom-up introduction to computing; bits and operations on bits; number formats; arithmetic and logic operations; digital logic; the Von Neumann model of processing, including memory, arithmetic logic unit, registers, and instruction decoding and execution; introduction to structured programming and debugging; machine and assembly language programming; the structure of an assembler; physical input/output through device registers; subroutine call/return; trap instruction; stacks and applications of stacks.",

    EE309S: "Analysis, design, and construction of a solar-powered car for national competitions involving other universities. Study of electrical, mechanical, and aerodynamic systems. Electrical Engineering 309K (Topic: Development of a Solar Car for NASC) and 309S may not both be counted.",

    EE312: "Basic problem solving, design and implementation techniques for imperative programming; structured programming in the C/C++ language; programming idioms; introduction to software design principles, including modularity, coupling and cohesion; introduction to software engineering tools; elementary data structures; asymptotic analysis.",

    EE313: "Representation of signals and systems; system properties; sampling; Laplace and z-transforms; transfer functions and frequency response; convolution; stability; Fourier transform; feedback; and control applications. Computer analysis using MATLAB.",

    EE316: "Boolean algebra; analysis and design of combinational and sequential logic circuits; state machine design and state tables and graphs; simulation of combinational and sequential circuits; applications to computer design; and introduction to hardware description languages (HDLs) and field-programmable gate arrays (FPGAs).",

    EE319K: "Embedded systems; machine language execution; assembly and C language programming; local variables and subroutines; input/output synchronization; analog to digital conversion and digital to analog conversion; debugging; and interrupts.",

    EE411: "Capacitance and inductance; first- and second-order transient circuit response, including operational amplifier circuits; sinusoidal steady state analysis; Bode plots; complex power in single and balanced three-phase systems; transformers; two-port networks (Z-parameters and Y-parameters); and computer-aided analysis and design.",

    EE125N: "This course covers the work period of electrical engineering students in the Cooperative Engineering Program.",

    EE125S: "Practical work experience in industry or a research lab under the supervision of an engineer or scientist. Requires a substantial final report. May be repeated for credit, but only three hours may be counted toward an electrical engineering degree. Offered on the pass/fail basis only.",

    EE225MA: "This course covers the work period of electrical engineering students in the Cooperative Engineering Program. The student must complete Electrical Engineering 225MA and 225MB before a grade and degree credit are awarded.",

    EE225MB: "This course covers the work period of electrical engineering students in the Cooperative Engineering Program. The student must complete Electrical Engineering 225MA and 225MB before a grade and degree credit are awarded.",

    EE325: "Electrostatics and magnetostatics; properties of conductive, dielectric, and magnetic materials; solutions of Maxwell's equations; uniform plane wave applications; frequency- and time-domain analyses of transmission lines.",

    EE325K: "Solutions of time-varying Maxwell's equations with applications to antennas and wireless propagation; antenna theory and design, array synthesis; electromagnetic wave propagation, scattering, and diffraction; numerical methods for solving Maxwell's equations.",

    EE325L: "This course covers the work period of electrical and computer engineering students in the Cooperative Engineering Program. Forty laboratory hours a week for three semesters. The student must complete Electrical Engineering 325LX, 325LY, and 325LZ before a grade and degree credit are awarded. May be repeated for credit. Prerequisite: For 325LX, application to become a member of the Cooperative Engineering Program, approval of the dean, and appointment for a full-time cooperative work tour; for 325LY, Electrical Engineering 325LX and appointment for a full-time cooperative work tour; for 325LZ, Electrical Engineering 325LY and appointment for a full-time cooperative work tour.",

    EE333T: "Advanced engineering communication skills, with emphasis on technical documents, oral reports, and graphics; collaborative work involving online communication and research. May be counted toward the writing flag requirement. May be counted toward the ethics and leadership flag requirement.",

    EE334K: "Introduction to quantum mechanics; atoms and molecules; electron statistics; quantum theory of solids; electronic phenomena in semiconductors; and device applications based on these phenomena.",

    EE338L: "Analysis and design of analog integrated circuits; transistor models; simple and advanced current mirrors; single-ended amplifiers; differential amplifiers; operational amplifiers; frequency response; feedback theory; stability analysis; circuit nonidealities and noise; output stages; analog filters. CAD tools for circuit analysis and design.",

    EE339: "Semiconductor materials; atomic orbitals to energy band structure of semiconductors; charge carrier transport, electron-hole generation and recombination; p-n junctions and Schottky barriers; bipolar and filed-effect transistors; and introduction to optoelectronic devices.",

    EE339S: "An investigation of basic principles of photovoltaic devices which convert light into charger carriers (electrons and holes). Topics include electrons and holes in semiconductors, generation and recombination, junctions, analysis of the p-n junction, silicon and III-V semiconductor solar cell design and optimization, thin film solar cell technologies, managing light, strategies for higher efficiency, and a brief overview of non-photovoltaic approaches to solar energy conversion. Electrical Engineering 339S and 379K (Topic 4: Solar Energy Conversion Devices) may not both be counted. ",

    EE340P: "Explore sub-50nm fabrication using mechanical patterning techniques. Provide an overview of photolithography, mechanical nanopatterning processes, hot embossing, and UV imprint lithography. Wafer-scale and roll-to-roll nanopatterning will be introduced with applications in electronics, photonics, and nanomedicine. Physics of nanoreplication, process limits, template (mold) fabrication, defect mechanisms, and factors affecting throughput will also be discussed. ",

    EE341: "Fundamentals of electric machines. Electromechanical energy conversion; magnetic circuits, transformers, and energy conversion devices; and an introduction to power electronics. Motor drive fundamentals and applications.",

    EE347: "Modern optical wave phenomena with applications to imaging, holography, fiber optics, lasers, and optical information processing.",

    EE348: "Principles of operation and applications of lasers, optical modulators, and optical detectors. Meets with EE 396V.",

    EE351K: "Probability, random variables, statistics, and random processes, including counting, independence, conditioning, expectation, density functions, distributions, law of large numbers, central limit theorem, confidence intervals, hypothesis testing, statistical estimation, stationary processes, Markov chains, and ergodicity.",

    EE351M: "Sampling, aliasing, truncation effects; discrete and fast Fourier transform methods; convolution and deconvolution; finite and infinite impulse response filter design methods; Wiener, Kalman, noncausal, linear phase, median, and prediction filters; and spectral estimation.",

    EE360C: "Advanced problem solving methods; algorithm design principles; complexity analysis; study of the nature, impact, and handling of intractability; study of common algorithmic classes and their applications.",

    EE360F: "Introduction to the discipline of software engineering. Includes software system creation and evolution; fundamental concepts and principles of software product and software process systems, including requirements, architecture and design, construction, deployment, and maintenance; and documentation and document management, measurement and evaluation, software evolution, teamwork, and project management.",

    EE360K: "Communication channels and their impairments; modulation; demodulation; probability-of-error analysis; source coding; error control coding; link budget analysis; equalization; synchronization and multiple access; spread spectrum; applications in wireline and wireless communication systems.",

    EE360P: "Multithreaded programming, semaphores, monitors, lock-free synchronization, resource allocation; client/server distributed systems programming, logical clocks, global snapshots and property evaluation, leader election, consensus, protection, and transactions.",

    EE360T: "Basic concepts and techniques used in testing software and finding bugs. Includes process, unit, integration, and system testing; manual and automatic techniques for generation of test inputs and validation of test outputs; and coverage criteria. Focus on functional testing. Electrical Engineering 360T and 379K (Topic: Software Testing) may not both be counted.",

    EE361C: "Theoretical and practical aspects of designing multicore software systems; programming constructs for concurrent computation; openMP; sequential consistency; linearizability; lock-based synchronization; lock-free synchronization; wait-free synchronization; consensus number; software transactional memory; testing and debugging parallel programs; race detection; concurrent data structures such as stacks, queues, linked lists, hash tables, and skiplists; formal models; temporal logic;reachability analysis; and parallel graph algorithms.",

    EE361Q: "Methods and technology for acquiring, representing, documenting, verifying, validating, and maintaining requirements; text-based, graphic-based, and computational requirements model representations; requirements analysis to synthesize and resolve conflicts among disparate stakeholder viewpoints; requirements traceability and evolution, and change management. Electrical Engineering 361Q and 379K (Topic: Requirements Engineering) may not both be counted.",

    EE361R: "Modeling of active and passive devices and transmission line structures at high frequencies. Analysis and design of radio-frequency electronic circuits including amplifiers, mixers, multipliers, detectors, and oscillators; transistor-, circuit-, and system-level design methods, challenges, and topologies; noise and distortion analysis; and evaluation of modern radio systems. The equivalent of three lecture hours a week for one semester. Electrical Engineering 361R and 379K (Topic: Radio Frequency Circuit Design) may not both be counted. Prerequisite: Electrical Engineering 325 and 438 with a grade of at least C- in each.",

    EE362G: "Fundamental of smart electric power grids; smart grid architecture, communications, measurement, sensing, design, performance, standards and cyber security; distributed energy, renewable sources, and energy storage; interoperability.",

    EE362K: "Analysis of linear automatic control systems in time and frequency domains; stability analysis; state variable analysis of continuous-time and discrete-time systems; root locus; Nyquist diagrams; Bode plots; sensitivity; lead and lag compensation.",

    EE362Q: "Introduction to and analysis of power quality and harmonic phenomena in electric power systems. Includes characteristics and definitions, voltage sags, electrical transients, harmonics, mitigation techniques, and standards of power quality and harmonics. Electrical Engineering 362Q and 379K (Topic: Power Quality and Harmonics) may not both be counted.",

    EE362R: "Introduction to renewable energy sources and their integration into power systems. Includes wind energy: resources, turbines, blades, rotor power characteristics, generators, active and reactive power, variability, and voltage regulation",

    EE362S: "Analysis, design, and construction of a solar-powered car for national competitions involving other universities. Study of electrical, mechanical, and aerodynamic systems. Electrical Engineering 362S and 379K (Topic: Development of a Solar Car for NASC) may not both be counted. MEETS WITH E E 309S, ASE 379L , M E 379M.",

    EE363M: "Design principles in microwave and radio frequency systems; transmission lines and waveguides; S-parameter representation; impedance matching; microwave network analysis; microwave devices and components; electromagnetic effects in high-speed/high-frequency applications.",

    EE363N: "Principles of acoustics, with applications drawn from audio engineering, biomedical ultrasound, industrial acoustics, noise control, room acoustics, and underwater sound.",

    EE364D: "Introduction to the engineering design process; assessing engineering problems and customer needs; acquiring, documenting, and verifying requirements; high-level system design principles; effects of economic, environmental, ethical, safety, and social issues in design; writing design specifications. Electrical Engineering 155 and 364D may not both be counted.",

    EE364E: "First course in a two-semester sequence that concludes with Electrical Engineering 464S. Teams of students starting companies focus on skill development and mentoring in start-up formation, technology development, market validation, marketing, sales, operations, human resources, program management, and finance. Includes discussion of the role of intellectual property, the social issues in design, as well as ethical and safety considerations. Emphasis on written and oral presentation of start-up activities. The equivalent of three lecture hours a week for one semester, with additional hours to be arranged. Only one of the following may be counted: Computer Science 378 (Topic: Interdisciplinary Entrepreneurship),Electrical Engineering 364E, Engineering Studies 377 (Topic: Interdisciplinary Entrepreneurship), Management 337 (Topic: Interdisciplinary Entrepreneurship). Electrical Engineering 364E and 464S may not be counted by students with credit for Electrical Engineering 364D, 464H, 464K, or 464R. Prerequisite: Credit with a grade of at least C- in Aerospace Engineering 333T, Biomedical Engineering 333T, Chemical Engineering 333T, Civil Engineering 333T, Electrical Engineering 333T, Mechanical Engineering 333T, or Petroleum and Geosystems Engineering 333T; credit with a grade of at least C- or registration for Electrical Engineering 440, 445L (or 345L), 445S (or 345S), and 461L or 462L (or 362L); and consent of instructor.",

    EE368L: "Fundamentals of power systems emphasized through laboratory experiments; complex power, three-phase circuits, per-unit system, transformers, synchronous machines, transmission line models, steady-state analysis, induction machines, capacitor banks, protective relaying, surge arrestors, and instrumentation. Three lecture hours and three laboratory hours a week for one semester. Electrical Engineering 368L and 379K (Topic: Power Systems Apparatus and Laboratory) may not both be counted. Prerequisite: Electrical Engineering 411 or 331 with a grade of at least C-; and credit with a grade of at least C- or registration for Aerospace Engineering 333T, Biomedical Engineering 333T,Chemical Engineering 333T, Civil Engineering 333T, Electrical Engineering 333T, Mechanical Engineering 333T, or Petroleum and Geosystems Engineering 333T.",

    EE369: "Three-phase power systems, system component models, symmetrical components, and admittance and impedance matrices. Formulation and analysis of loadflow, short circuit, and stability for electric grids. Economic operation.",

    EE371R: "Digital image acquisition, processing, and analysis; algebraic and geometric image transformations; two-dimensional Fourier analysis; image filtering and coding.",

    EE374K: "Application of electrical engineering principles in the design of electronic instrumentation at the circuit-board level for the measurement of pressure, temperature, flow, and impedance. Also includes the study of light intensity, bioelectric potentials, and stimulation devices such as pacemakers and defibrillators. Focus on design considerations specific to electro-medical environments, safety and efficacy, and public policy issues.",

    EE374L: "An in-depth examination of selected topics in biomedical engineering, such as optical and thermal properties of laser interaction with tissue; measurement of perfusion in the microvascular system; diagnostic imaging; interaction of living systems with electromagnetic fields; robotic surgical tools; ophthalmic instrumentation; noninvasive cardiovascular measurements.",

    EE379K: "Course number may be repeated for credit when the topics vary",

    EE422C: "Methods for engineering software with a focus on abstraction; specification, design, implementation, and testing of object-oriented code using a modern development tool-set for complex systems; design and implementation of object-oriented programs in Java; abstract data types; inheritance; polymorphism; parameterized types and generic programming; the operation and application of commonly used data structures; exception handling and fault tolerance; introduction to algorithm analysis; teamwork models.",

    EE438: "Analysis and design of electronic circuits using semiconductor devices. Basic device physics and small-signal modeling for diodes, bipolar junction transistors, and metal-oxide-semiconductor transistors; operation region and biasing; basic switching circuits; single-stage and multi-stage amplifier design and analysis; input and output impedance characteristics of amplifiers; frequency response; AC and DC coupling techniques; differential amplifiers and output stages.",

    EE438K: "Analysis and design of analog electronic circuits; transistor models; single-ended amplifiers; differential amplifiers; operational amplifiers ; frequency response; feedback theory; stability analysis; circuit nonidealities; op-amp-based circuits; output stages; power amplifiers; passive and active analog filters; and relaxation oscillators.",

    EE440: "Integrated circuit processing; crystal growth and wafer preparation; epitaxial growth; oxidation, diffusion, and ion implantation; thin-film deposition techniques; and lithography and etching.",

    EE445L: "Design of microcontroller-based embedded systems; interfacing from both a hardware and software perspective; and applications, including audio, data acquisition, and communication systems.",

    EE445M: "Embedded microcomputer systems; implementation of multitasking, synchronization, protection, and paging; operating systems for embedded microcomputers; design, optimization, evaluation, and simulation of digital and analog interfaces; real-time microcomputer software; applications, including data acquisition and control. Three lecture hours and three laboratory hours a week for one semester.",

    EE445S: "Architectures of programmable digital signal processors; programming for real-time performance; design and implementation of digital filters, modulators, data scramblers, pulse shapers, and modems in real time; and interfaces to telecommunication systems.",

    EE460J: "Predictive modeling, regression and classification, data cleaning and preprocessing, feature engineering, unsupervised methods, principal component analysis, data clustering, model selection and feature selection, entropy and information theory, neural networks, deep learning, machine learning for signals and time-series data.",

    EE460M: "Organization, design, simulation, synthesis, and testing of digital systems; hardware description languages (HDLs); field programmable gate arrays (FPGAs); hardware implementation of arithmetic and other algorithmic processes; state machine charts; microprogramming; and microprocessor design.",

    EE460N: "Characteristics of instruction set architecture and microarchitecture; physical and virtual memory; caches and cache design; interrupts and exceptions; integer and floating-point arithmetic; I/O processing; buses; pipelining, out-of-order execution, branch prediction, and other performance enhancements; design trade-offs; case studies of commercial microprocessors. Laboratory work includes completing the behavioral-level design of a microarchitecture.",

    EE460R: "Theory and practice of very-large-scale integration (VLSI) circuit design. Metal-oxide-semiconductor (MOS) transistors; static and dynamic complementary metal-oxide-semiconductor (CMOS) combinational and sequential circuits; design of adders, multipliers, and shifters; performance, power consumption and testing. CAD tools for layout, timing analysis, synthesis, physical design, and verification. Three lecture hours and three laboratory hours a week for one semester. Prerequisite:Electrical Engineering 316 and 438 with a grade of at least C- in each",

    EE461L: "The design and development of large-scale software systems using automated analysis tools. Generation of concrete software engineering artifacts at all stages of the software life-cycle. Design principles and methods; design and modeling tools; collaborative development environment; object-oriented design and analysis; design patterns and refactoring; integration and testing tools; debugger and bug finder; program comprehension; software life-cycle and evolution.",

    EE461P: "Goals, methods, and applications of data mining. Includes data preprocessing, sampling, and visualization; algorithms for machine learning; clustering, classification, and predicting and forecasting; mining the Internet for content, link structure, and usage information; search engine design and social network analysis; and statistical methods. Three lecture hours a week for one semester. Electrical Engineering 361M and 379K (Topic: Introduction to Data Mining) may not both be counted. ",

    EE461S: "Introductory course on operating system design and implementation; the shell; process management and system calls; memory management; thread management, scheduling, synchronization and concurrency; file systems; input/output systems; virtual machines; networking and security.",

    EE462L: "Analysis, design, and operation of power electronic circuits; power conversion from AC to DC, DC to DC, and DC to AC; rectifiers, inverters, and pulse width modulated motor drives. Laboratory work focuses on the use of energy from renewable sources such as photovoltaics and wind.",

    EE464H: "Restricted to students in the Engineering Honors Program. Design and experimental projects done under the direction of a University faculty member; the ethics of design for safety and reliability; emphasis on written and oral reporting of engineering projects.",

    EE464K: "Design and experimental projects done in Department of Electrical and Computer Engineering laboratories; the ethics of design for safety and reliability; emphasis on written and oral reporting of engineering projects.",

    EE464R: "Design and experimental projects done under the supervision of a University faculty member; the ethics of design for safety and reliability; emphasis on written and oral reporting of engineering projects.",

    EE464S: "Continuation of Electrical Engineering 364E. Completion of a practical engineering product design; validation of the design through prototype construction and testing, modeling and simulation, and manufacturability analysis. Development of a completed company prospectus, seeking venture funding for the project, and participating in an innovative technology forum to present the proposed start-up company to potential investors. Three lecture hours and six laboratory hours a week for one semester.Electrical Engineering 364E and 464S may not be counted by students with credit for 364D, 464H, 464K, or 464R. Prerequisite: Electrical Engineering 364E with a grade of at least C-; one of the following courses with a grade of at least C-: Electrical Engineering 438, 449, 445L (or 345L), 445S (or 345S),461L, 462L (or 362L); and consent of instructor.",

    EE471C: "The fundamentals of wireless communication from a digital signal processing perspective; linear modulation, demodulation, and orthogonal frequency division multiplexing; synchronization, channel estimation, and equalization; communication in fading channels; and wireless standards. Electrical Engineering 371C and 379K (Topic: Wireless Communications Laboratory) may not both be counted.",

    EE679HA: "Research performed during two consecutive semesters under the supervision of an engineering faculty member; topics are selected jointly by the student and the faculty member with approval by the director of the Engineering Honors Program. The student makes an oral presentation and writes a thesis. Students pursuing both the Bachelor of Arts, Plan II, and a bachelor's degree in engineering may use this course to fulfill the thesis requirement for the Bachelor of Arts, Plan II.",

    EE679HB: "Research performed during two consecutive semesters under the supervision of an engineering faculty member; topics are selected jointly by the student and the faculty member with approval by the director of the Engineering Honors Program. The student makes an oral presentation and writes a thesis. Students pursuing both the Bachelor of Arts, Plan II, and a bachelor's degree in engineering may use this course to fulfill the thesis requirement for the Bachelor of Arts, Plan II.",

    EEX29S: "This course is used to record credit the student earns while enrolled at another institution in a program administered by the University's Study Abroad Office. Credit is recorded as assigned by the study abroad adviser in the Department of Electrical and Computer Engineering. University credit is awarded for work in an exchange program; it may be counted as coursework taken in residence. Transfer credit is awarded for work in an affiliated studies program. May be repeated for credit when the topics vary.",

    EEX60: "Elective course open to upper-division students in electrical engineering for original investigation of special problems approved by the department. For each semester hour of credit earned, the equivalent of three laboratory hours a week for one semester. May be repeated for credit. Prerequisite: Consent of instructor.",
}