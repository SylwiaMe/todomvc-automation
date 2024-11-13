# ToDoMVC Testing Notes

## addEmoji initial tests

- Unable to add ToDo item to the list with 1 character only, except emoji 
- Unable to add ToDo item to the list with 0 characters or space only
- Some special characters render as their HTML encoded versions. "&" special character renders as "&amp;"

## ToDo
- Add assertions
- More tests for ToDoPage
- Add assertion to addEmoji that tests whether todo item.getText() == exact emoji input
- 

## Done
- Replace thread.sleep with implicit wait
- Use rootUrl variable in HomePage