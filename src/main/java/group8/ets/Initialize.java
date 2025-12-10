package group8.ets;

/*
CLASS INFORMATION:
The Initialize class is responsible for setting up initial configurations and resources for the Educational Testing System (ETS).
It may include methods to initialize databases, load configuration files, and prepare necessary services.
 */

import group8.ets.quizmaterials.topicandquestions.QuestionFactory;
import group8.ets.quizmaterials.topicandquestions.Topic;
import group8.ets.quizmaterials.topicandquestions.TopicBuilder;
import group8.ets.services.AuthService;

public class Initialize {

    public static void init() {

        //Initialize Topics
        TopicBuilder topicBuilder = new TopicBuilder();
        QuestionFactory questionFactory = new QuestionFactory();
        Topic topic = topicBuilder.buildTopic("Mathematics", "All math related questions");

        // Difficulty level 1 (15 questions) - basic facts and arithmetic
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is 2+2?", 1, "4", "1", "2", "3"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is 5-3?", 1, "2", "1", "3", "4"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is 3*1?", 1, "3", "1", "2", "4"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is 10 divided by 2?", 1, "5", "2", "10", "8"));
        topic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("Is 5 a prime number?", 1, true));
        topic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("Is 10 greater than 20?", 1, false));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the square of 2?", 1, "4", "2", "6", "8"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("How many sides does a triangle have?", 1, "3", "2", "4", "5"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the value of 0+7?", 1, "7", "6", "8", "9"));
        topic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("A circle has corners.", 1, false));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is 1+1?", 1, "2", "1", "3", "4"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the next number after 4?", 1, "5", "6", "3", "7"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Which number is even?", 1, "4", "3", "7", "9"));
        topic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("Zero is an even number.", 1, true));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Which is a single digit number?", 1, "7", "12", "15", "21"));

        // Difficulty level 2 (15 questions) - intermediate arithmetic, basic algebra and geometry
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is 12+13?", 2, "25", "22", "23", "26"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is 6*7?", 2, "42", "36", "48", "40"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is 49 divided by 7?", 2, "7", "6", "8", "9"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the perimeter of a rectangle with sides 3 and 5?", 2, "16", "15", "8", "20"));
        topic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("An isosceles triangle has at least two equal sides.", 2, true));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Solve for x: x + 5 = 12", 2, "7", "6", "8", "5"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the area of a square with side length 4?", 2, "16", "8", "12", "10"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is 15 - 9?", 2, "6", "5", "7", "8"));
        topic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("The sum of angles in a triangle is 180 degrees.", 2, true));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is 9 + 8?", 2, "17", "16", "15", "18"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("If 3x = 12, what is x?", 2, "4", "3", "2", "6"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the mean of 2,4,6?", 2, "4", "3", "6", "5"));
        topic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("A rhombus always has right angles.", 2, false));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is 7 * 5?", 2, "35", "30", "25", "40"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is 100 - 45?", 2, "55", "45", "65", "60"));

        // Difficulty level 3 (15 questions) - advanced problems, algebra, basic calculus intuition, harder geometry
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Solve for x: 2x + 3 = 11", 3, "4", "3", "5", "2"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is 13 * 7?", 3, "91", "81", "99", "87"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the square root of 144?", 3, "12", "11", "10", "14"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("If f(x)=2x, what is f(5)?", 3, "10", "7", "12", "8"));
        topic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("The derivative of x^2 with respect to x is 2x.", 3, true));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the value of 17 + 28?", 3, "45", "44", "43", "46"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is 81 divided by 9?", 3, "9", "8", "7", "6"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("If a triangle has sides 3,4,5 is it a right triangle?", 3, "Yes", "No", "Impossible", "Only if scaled"));
        topic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("The angles of a right triangle add up to 180 degrees.", 3, true));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Solve: 3x - 2 = 10", 3, "4", "3", "2", "6"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is 0 factorial (0!)?", 3, "1", "0", "Undefined", "-1"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Which is a prime number?", 3, "29", "21", "27", "33"));
        topic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("The number e is approximately 2.718.", 3, true));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the product of -3 and -7?", 3, "21", "-21", "10", "-10"));
        topic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the cube of 2?", 3, "8", "6", "4", "12"));

        Topic scienceTopic = topicBuilder.buildTopic("General Science", "Questions covering Biology, Chemistry, and Physics");
        // Difficulty level 1 (15 questions) - Basic facts about nature and matter
        scienceTopic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("The sun is a star.", 1, true));
        scienceTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Which planet do we live on?", 1, "Earth", "Mars", "Venus", "Jupiter"));
        scienceTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the chemical symbol for water?", 1, "H2O", "O2", "CO2", "NaCl"));
        scienceTopic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("Humans breathe in Carbon Dioxide to survive.", 1, false));
        scienceTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("How many legs does a spider typically have?", 1, "8", "6", "4", "10"));
        scienceTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What color are most leaves?", 1, "Green", "Blue", "Purple", "Red"));
        scienceTopic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("Ice is the solid state of water.", 1, true));
        scienceTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Which animal lays eggs?", 1, "Chicken", "Dog", "Cat", "Cow"));
        scienceTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What do plants need to make food?", 1, "Sunlight", "Sand", "Rocks", "Darkness"));
        scienceTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("At what temperature does water boil (Celsius)?", 1, "100", "0", "50", "200"));
        scienceTopic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("Fish use lungs to breathe underwater.", 1, false));
        scienceTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Which is the largest planet in our solar system?", 1, "Jupiter", "Earth", "Saturn", "Mars"));
        scienceTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What creates honey?", 1, "Bees", "Ants", "Wasps", "Butterflies"));
        scienceTopic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("Gravity makes things fall down.", 1, true));
        scienceTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What organ pumps blood in the human body?", 1, "Heart", "Brain", "Liver", "Lungs"));

        // Difficulty level 2 (15 questions) - Intermediate biology and physical laws
        scienceTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What gas do plants absorb during photosynthesis?", 2, "Carbon Dioxide", "Oxygen", "Nitrogen", "Helium"));
        scienceTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the powerhouse of the cell?", 2, "Mitochondria", "Nucleus", "Ribosome", "Cytoplasm"));
        scienceTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the chemical symbol for Gold?", 2, "Au", "Ag", "Fe", "Cu"));
        scienceTopic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("Sound travels faster than light.", 2, false));
        scienceTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Which organ is the largest in the human body?", 2, "Skin", "Liver", "Brain", "Heart"));
        scienceTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the center of an atom called?", 2, "Nucleus", "Electron", "Proton", "Shell"));
        scienceTopic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("The human heart has 4 chambers.", 2, true));
        scienceTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Which planet is known as the Red Planet?", 2, "Mars", "Venus", "Jupiter", "Mercury"));
        scienceTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the hardest natural mineral?", 2, "Diamond", "Gold", "Iron", "Quartz"));
        scienceTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the pH level of pure water?", 2, "7", "1", "14", "5"));
        scienceTopic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("A whale is a fish.", 2, false));
        scienceTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Who formulated the laws of motion?", 2, "Isaac Newton", "Albert Einstein", "Galileo", "Tesla"));
        scienceTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What protects the Earth from UV radiation?", 2, "Ozone Layer", "Clouds", "Atmosphere", "Magnetic Field"));
        scienceTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Which blood type is the universal donor?", 2, "O Negative", "A Positive", "AB Negative", "B Positive"));
        scienceTopic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("Electrons carry a positive charge.", 2, false));

        // Difficulty level 3 (15 questions) - Advanced scientific concepts
        scienceTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the atomic number of Carbon?", 3, "6", "12", "8", "14"));
        scienceTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the speed of light (approx)?", 3, "299,792 km/s", "340 m/s", "100,000 km/s", "1,000 km/s"));
        scienceTopic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("Mitochondrial DNA is inherited only from the mother.", 3, true));
        scienceTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Which particle is known as the 'God Particle'?", 3, "Higgs Boson", "Quark", "Neutrino", "Photon"));
        scienceTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is Absolute Zero in Celsius?", 3, "-273.15", "-100", "0", "-459.67"));
        scienceTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Which element is a Noble Gas?", 3, "Neon", "Oxygen", "Nitrogen", "Chlorine"));
        scienceTopic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("Entropy generally decreases in an isolated system.", 3, false));
        scienceTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the basic functional unit of the nervous system?", 3, "Neuron", "Nephron", "Alveoli", "Glial"));
        scienceTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Who discovered Penicillin?", 3, "Alexander Fleming", "Louis Pasteur", "Marie Curie", "Darwin"));
        scienceTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What type of bond involves sharing electrons?", 3, "Covalent", "Ionic", "Hydrogen", "Metallic"));
        scienceTopic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("Light can behave as both a particle and a wave.", 3, true));
        scienceTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the main component of the Sun?", 3, "Hydrogen", "Helium", "Oxygen", "Carbon"));
        scienceTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Which Law of Thermodynamics states energy cannot be created or destroyed?", 3, "First", "Second", "Third", "Zeroth"));
        scienceTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the term for cells 'eating' particles?", 3, "Phagocytosis", "Osmosis", "Mitosis", "Diffusion"));
        scienceTopic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("Venus rotates in the opposite direction to most planets.", 3, true));

        Topic historyTopic = topicBuilder.buildTopic("World History", "Historical events, figures, and civilizations");
        // Difficulty level 1 (15 questions) - Famous figures and dates
        historyTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Who was the first President of the USA?", 1, "George Washington", "Abraham Lincoln", "Thomas Jefferson", "John Adams"));
        historyTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("In which country are the Pyramids of Giza?", 1, "Egypt", "Mexico", "China", "Peru"));
        historyTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What year did the Titanic sink?", 1, "1912", "1905", "1920", "1898"));
        historyTopic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("Christopher Columbus sailed in 1492.", 1, true));
        historyTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Where is the Eiffel Tower located?", 1, "Paris", "London", "Rome", "Berlin"));
        historyTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Which empire built the Colosseum?", 1, "Roman", "Greek", "Ottoman", "British"));
        historyTopic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("The Great Wall is located in Japan.", 1, false));
        historyTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Who wrote 'Romeo and Juliet'?", 1, "Shakespeare", "Dickens", "Hemingway", "Orwell"));
        historyTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What ancient civilization used Hieroglyphics?", 1, "Egyptians", "Mayans", "Romans", "Greeks"));
        historyTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Who is on the US $5 bill?", 1, "Lincoln", "Washington", "Franklin", "Hamilton"));
        historyTopic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("Adolf Hitler was the leader of Nazi Germany.", 1, true));
        historyTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Which war was fought between the North and South in the US?", 1, "Civil War", "Revolutionary War", "World War 1", "Vietnam War"));
        historyTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What was the name of the ship Pilgrims sailed on?", 1, "Mayflower", "Santa Maria", "Titanic", "Beagle"));
        historyTopic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("Neil Armstrong was the first man on the moon.", 1, true));
        historyTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Where did the Olympics originate?", 1, "Greece", "Italy", "France", "China"));

        // Difficulty level 2 (15 questions) - Wars, Revolutions, and Eras
        historyTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("When did World War 1 begin?", 2, "1914", "1918", "1939", "1945"));
        historyTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Who was the first female Prime Minister of the UK?", 2, "Margaret Thatcher", "Theresa May", "Queen Victoria", "Angela Merkel"));
        historyTopic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("The Berlin Wall fell in 1989.", 2, true));
        historyTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Which revolution started in 1789?", 2, "French Revolution", "American Revolution", "Russian Revolution", "Industrial Revolution"));
        historyTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Who painted the Mona Lisa?", 2, "Da Vinci", "Van Gogh", "Picasso", "Michelangelo"));
        historyTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("The Cold War was primarily between which two powers?", 2, "USA and USSR", "UK and Germany", "USA and China", "France and Russia"));
        historyTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Where was Nelson Mandela a leader?", 2, "South Africa", "Kenya", "Nigeria", "Egypt"));
        historyTopic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("The Aztec civilization was located in modern-day Brazil.", 2, false));
        historyTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What was the primary cause of the Black Death?", 2, "Bubonic Plague", "Smallpox", "Cholera", "Flu"));
        historyTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Who invented the printing press?", 2, "Gutenberg", "Edison", "Bell", "Newton"));
        historyTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("In which year did World War 2 end?", 2, "1945", "1939", "1918", "1950"));
        historyTopic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("Napoleon Bonaparte was an Emperor of France.", 2, true));
        historyTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Which country gifted the Statue of Liberty to the USA?", 2, "France", "UK", "Germany", "Italy"));
        historyTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Who led the Salt March in India?", 2, "Gandhi", "Nehru", "Jinnah", "Modi"));
        historyTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What empire was Genghis Khan the leader of?", 2, "Mongol", "Roman", "Ottoman", "British"));

        // Difficulty level 3 (15 questions) - Specific treaties, ancient history, and politics
        historyTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("In what year did the Roman Empire (Western) fall?", 3, "476 AD", "1453 AD", "300 BC", "1066 AD"));
        historyTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Which treaty ended World War 1?", 3, "Treaty of Versailles", "Treaty of Paris", "Treaty of Tordesillas", "Treaty of Ghent"));
        historyTopic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("The Hundred Years' War lasted exactly 100 years.", 3, false));
        historyTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What was the capital of the Byzantine Empire?", 3, "Constantinople", "Rome", "Athens", "Alexandria"));
        historyTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Who was the last Tsar of Russia?", 3, "Nicholas II", "Peter the Great", "Ivan the Terrible", "Alexander I"));
        historyTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Which battle took place in 1066?", 3, "Battle of Hastings", "Battle of Waterloo", "Battle of Yorktown", "Battle of Agincourt"));
        historyTopic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("The Rosetta Stone allowed scholars to translate Hieroglyphics.", 3, true));
        historyTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Which event triggered the start of WWI?", 3, "Assassination of Archduke Franz Ferdinand", "Invasion of Poland", "Bombing of Pearl Harbor", "Sinking of Lusitania"));
        historyTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Who was the longest-reigning British monarch?", 3, "Louis XIV (France)", "Queen Victoria", "Queen Elizabeth II", "Henry VIII"));
        historyTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What was the name of the legislative body in ancient Rome?", 3, "Senate", "Parliament", "Congress", "Assembly"));
        historyTopic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("The Ottoman Empire dissolved after World War 1.", 3, true));
        historyTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Which Chinese dynasty built the majority of the Great Wall?", 3, "Ming", "Qin", "Han", "Tang"));
        historyTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Who wrote 'The Communist Manifesto'?", 3, "Marx and Engels", "Lenin", "Stalin", "Trotsky"));
        historyTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What year was the Magna Carta signed?", 3, "1215", "1066", "1492", "1776"));
        historyTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Which crisis occurred in October 1962?", 3, "Cuban Missile Crisis", "Suez Crisis", "Berlin Blockade", "Korean War"));

        Topic geoTopic = topicBuilder.buildTopic("Geography", "Countries, Capitals, and Landscapes");
        // Difficulty level 1 (15 questions) - Continents and major landmarks
        geoTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Which is the largest continent?", 1, "Asia", "Africa", "North America", "Europe"));
        geoTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the capital of the USA?", 1, "Washington D.C.", "New York", "Los Angeles", "Chicago"));
        geoTopic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("Africa is a country.", 1, false));
        geoTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Where are kangaroos found naturally?", 1, "Australia", "Austria", "Africa", "America"));
        geoTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the shape of the Earth?", 1, "Sphere (Geoid)", "Flat", "Cube", "Pyramid"));
        geoTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Which ocean is the largest?", 1, "Pacific", "Atlantic", "Indian", "Arctic"));
        geoTopic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("Antarctica is covered in ice.", 1, true));
        geoTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Which country has the most people?", 1, "India", "USA", "Russia", "Brazil"));
        geoTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the highest mountain in the world?", 1, "Mount Everest", "K2", "Mount Fuji", "Kilimanjaro"));
        geoTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Paris is the capital of which country?", 1, "France", "Germany", "Spain", "Italy"));
        geoTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("How many states are in the USA?", 1, "50", "51", "48", "52"));
        geoTopic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("The Nile River is in South America.", 1, false));
        geoTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Which direction does a compass point?", 1, "North", "South", "East", "West"));
        geoTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the imaginary line around the middle of the Earth?", 1, "Equator", "Prime Meridian", "Tropic of Cancer", "Axis"));
        geoTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Japan is an island nation.", 1, "True", "False", "Partially", "Unknown"));

        // Difficulty level 2 (15 questions) - Capitals and physical geography
        geoTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the capital of Japan?", 2, "Tokyo", "Kyoto", "Osaka", "Seoul"));
        geoTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Which is the longest river in the world?", 2, "Nile", "Mississippi", "Yangtze", "Danube"));
        geoTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Which country has the largest land area?", 2, "Russia", "Canada", "China", "USA"));
        geoTopic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("The Sahara is the largest hot desert.", 2, true));
        geoTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the capital of Italy?", 2, "Rome", "Milan", "Venice", "Naples"));
        geoTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Where is the Great Barrier Reef located?", 2, "Australia", "Belize", "Philippines", "Indonesia"));
        geoTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Which canal connects the Atlantic and Pacific Oceans?", 2, "Panama Canal", "Suez Canal", "Erie Canal", "Grand Canal"));
        geoTopic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("Mount Kilimanjaro is in Europe.", 2, false));
        geoTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the capital of Canada?", 2, "Ottawa", "Toronto", "Vancouver", "Montreal"));
        geoTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Which continent is the Amazon Rainforest in?", 2, "South America", "Africa", "Asia", "Australia"));
        geoTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the smallest country in the world?", 2, "Vatican City", "Monaco", "Nauru", "San Marino"));
        geoTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Which country is famous for its fjords?", 2, "Norway", "Spain", "Greece", "Egypt"));
        geoTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Which sea separates Europe and Africa?", 2, "Mediterranean", "Red", "Black", "Caspian"));
        geoTopic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("There are 7 continents.", 2, true));
        geoTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the currency of the UK?", 2, "Pound Sterling", "Euro", "Dollar", "Franc"));

        // Difficulty level 3 (15 questions) - Demographics, obscure capitals, and landmarks
        geoTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the capital of Australia?", 3, "Canberra", "Sydney", "Melbourne", "Perth"));
        geoTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the capital of Brazil?", 3, "Brasilia", "Rio de Janeiro", "Sao Paulo", "Salvador"));
        geoTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Which country has the most islands?", 3, "Sweden", "Indonesia", "Philippines", "Canada"));
        geoTopic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("Lake Baikal is the deepest lake in the world.", 3, true));
        geoTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the capital of Turkey?", 3, "Ankara", "Istanbul", "Izmir", "Antalya"));
        geoTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Which river passes through 10 countries?", 3, "Danube", "Nile", "Rhine", "Amazon"));
        geoTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Which country is also known as the 'Land of the Thunder Dragon'?", 3, "Bhutan", "Nepal", "China", "Thailand"));
        geoTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the highest waterfall in the world?", 3, "Angel Falls", "Niagara Falls", "Victoria Falls", "Iguazu Falls"));
        geoTopic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("Lesotho is a country entirely inside South Africa.", 3, true));
        geoTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the capital of Switzerland?", 3, "Bern", "Zurich", "Geneva", "Basel"));
        geoTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Where is the Mariana Trench located?", 3, "Pacific Ocean", "Atlantic Ocean", "Indian Ocean", "Arctic Ocean"));
        geoTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Which two countries share the longest international border?", 3, "USA and Canada", "Russia and Kazakhstan", "Chile and Argentina", "China and Mongolia"));
        geoTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("What is the capital of Egypt?", 3, "Cairo", "Alexandria", "Giza", "Luxor"));
        geoTopic.addTrueOrFalseQuestion(questionFactory.createTrueFalseQuestion("Istanbul is located on two continents.", 3, true));
        geoTopic.addMCQQuestion(questionFactory.createMultipleChoiceQuestion("Which desert is the largest in the world (including polar)?", 3, "Antarctic Desert", "Sahara", "Arabian", "Gobi"));

        // Initialize Premade Student Accounts
        AuthService.getInstance().register("a", "a", "a");
        AuthService.getInstance().register("b", "b", "b");
        AuthService.getInstance().register("c", "c", "c");

        Utility.log("ETS system initialized.");
    }
}
