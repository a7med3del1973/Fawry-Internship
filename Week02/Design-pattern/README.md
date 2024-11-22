# Design Patterns
# Design Principles

## I can't explain & organize it better than my friend [Sakr_](https://github.com/Ahmed-Mohmed-Sakr/Fawry-Intern/tree/main/src/main/java/org/tasks/week1/Design_Principles) :)

- ### Eng.Ahmed Ali [Session](https://drive.google.com/file/d/119uReMUejT4WrFITEs-NeJ3jhkANI9xO/view?usp=sharing&t=1) & [Slide](https://docs.google.com/presentation/d/10vaAvSVvY5s6_jS8t63uiQyrSU9788LJ/edit?usp=drive_link&ouid=106602249169714255267&rtpof=true&sd=true)

## Task:

![tmp_aaa353d0-f4fe-4355-9f56-9f16688d438e](https://github.com/user-attachments/assets/ac63b656-ccf0-4753-9028-da43df62172e)

- Check the above picture and create a system that can simulate the process of creating these furniture.
- Use your knowledge in design patterns mainly the abstract factory pattern.

- ### My solution:
  - I made 3 families for the furniture: `Chair`, `Table`, and `Sofa`.
  - Each family has 3 types: `Modern`, `Victorian`, and `Art-Deco`.
  - I created an Enum for the types of furniture.
  - I created 3 Factories for each family, then AbstractFactory to handle these factories.
  - Every Factory should detect the type of the furniture then return the appropriate object.

Check the code for better understanding.
