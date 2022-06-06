# AccessibilityTest
Accessibility test on BOA site.

Acceptance Criteria:
- Idea is to run the accessibility test on BOA site with a single flag.. If you switch the flag off by passing the value "runAXE=False" you can turn the AXE analysis on this project and if you want to run the AXE tool analysis on all the pages then simply pass the "runAXE=True" value. By default value will be True.
- I made the code in a way it is just simple steps
  * Clone/download this project.
  * setup the project in any IDE
  * run the boaAccesiblity file
You can also see while running I made the element boarders highligh in Green color so that we know what selenium is doing.
- You can find the accessibility voilaiton report in file Voilation_Report.docx
- This project can be enhanced by writting more implicit waits and adding properties from external sources(for example runAXE flag value). Also we can make a base framework of selenium and exted that framework to any appplication. Also we can extend this by integrate any tools or write our one rules if needed for analysing the website.




<h1>Project execution Recording can be seen here</h1>


https://user-images.githubusercontent.com/9115366/172140331-be8220de-f20c-4a1e-8a3b-de0b828804db.mp4







## Brief Summary
* Most of the issues where with **ARIA** attribute where WCAG standards are missing. If ARIA attribute is not as per standard it might effect the text to speech tools where it might not read out properly.
* Few are not having unique ID attributes. entire DOm should have unique id values for all elements on page.
* Form elemnt doesn't have lable. This will also be an issue for text to speech tools if there is no lable.
* There are many elements without landmark, this is one more problem for screen readers.


### Voilation report is also present in the project Voilation_report.docx







## Project Screenshots with Accessibility Voilation output:
<img width="1363" alt="Screenshot 2022-06-06 at 3 21 01 PM" src="https://user-images.githubusercontent.com/9115366/172139052-31fe7a78-1f6e-405b-84d7-71ce01f103ff.png">

<img width="1349" alt="Screenshot 2022-06-06 at 3 21 28 PM" src="https://user-images.githubusercontent.com/9115366/172139111-97e7dc19-08a5-4514-8aa8-597a96a474d3.png">

<img width="1440" alt="Screenshot 2022-06-06 at 3 22 04 PM" src="https://user-images.githubusercontent.com/9115366/172139224-65c888a5-3593-4bf8-8382-5fd164365e4e.png">



