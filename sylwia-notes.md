# ToDoMVC Testing Notes

## addEmoji initial tests

- Unable to add ToDo item to the list with 1 character only, except emoji 
- Unable to add ToDo item to the list with 0 characters or space only
- Some special characters render as their HTML encoded versions. "&" special character renders as "&amp;"

## ToDo
- Try to break assertions
- Add assertion to addEmoji that tests whether todo item.getText() == exact emoji input
- To complete few ToDos from the list (not all) and test markComplete?
- ToDo items have a character limit (long don't cause issues)
- Test more frameworks 
- The list can be filtered on todo items' completion states
- Clear all completed items
- Reordering Todos

## Done
- Replace thread.sleep with implicit wait
- Use rootUrl variable in HomePage
- New ToDo can be added 
- Empty ToDO items cannot be added 
- Accented char in ToDo doesn't cause problems
- Edit ToDo
- Delete ToDO (individually)
- All ToDo items may be marked as complete/incomplete at once
- Status bar always displays a count of remaining todo items 
- Assertions

## Problems
- Emojis rendering as HTML encoded version 
- Special chars rendering as HTML encoded version 

## Worth working on in the future
- dividing the words nicely without breaking them when Todo input is long 