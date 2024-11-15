# ToDoMVC Testing Notes

Tested browser: Google Chrome - latest version
Tested framework: React

## Unavailable Frameworks:
- Humble + GopherJS (https://todomvc.com/examples/humble/)
- SomaJS (https://todomvc.com/examples/somajs/)

Framework missing styling:
- Aurelia (https://todomvc.com/examples/aurelia/)

## Planned test cases:
1. New todo items can be added
2. Empty todo items cannot be added
3. Todo items have a character limit - long todos don’t cause issues
4. Todo items can contain an emoji
5. Todo items can contain punctuation/special characters
6. Todo items can contain an accented character
7. Todo items can always be modified with double click
8. Todo items can always be individually deleted
9. A todo item can be marked completed or incomplete
10. All todo items can be marked as completed, whether they have been completed or not
11. If all todo items are marked as completed, they can all be marked as incomplete in one go
12. The list can be filtered on todo items' completion states
13. Complete todo items can be cleared from the list
14. Status bar always displays a count of remaining todo items left to do
15. Todo items can be reordered*

## Observations from initial exploratory testing session
- Ref.(7) "Todo items can always be modified with double click." - functionality not clear enough on the browser
- *Ref.(15) "Todo items can be reordered." This test failed, functionality does not work on the browser.

## Observations based on automated tests

- Unable to add ToDo item to the list with 1 character only, except emoji (depends on framework, emoji counts as 2 chars?)
- Unable to add ToDo item to the list with 0 characters or space only


## ToDo (if more time given)
- Collaborate with Developers to write more consistent IDs for elements across frameworks. This will speed up future automation.
- More rigorous tests for Boundary Values Analysis
- Wider coverage - more browsers and frameworks - the HomePage file caters for this. We can run our tests for every framework
  and adjust locators as needed.
- Reordering Todos - (as it is not working atm) try to propose solution and test it
- Refactoring more code where needed
- screenshots - keep/remove where needed

## Done
- Replaced thread.sleep with implicit wait
- Use rootUrl variable in HomePage
- New ToDo can be added
- Empty ToDO items cannot be added
- Accented char in ToDo doesn't cause problems
- Edit ToDo
- Delete ToDO (individually)
- All ToDo items may be marked as complete/incomplete at once
- Status bar always displays a count of remaining todo items
- Assertions
- Add assertion to addEmoji that tests whether todo item.getText() == exact emoji input
- ToDo items have a character limit (long don't cause issues)
- The list can be filtered on todo items' completion states
- Clear complete button removes Todos from the list
- Page Object Model used
- 14/15 test cases covered

## Discoveries
- Frameworks accept different minimum input lengths (e.g. React 2, Marionette 1)
- 2 frameworks are missing and 1 renders with no styling. 
- Apart from below the React application works as intended.
- With long inputs, words get split between lines.
- Some special characters render as their HTML encoded versions. e.g. "&" special character renders as "&amp;"(we have tested it -
  more insight below)

## Special Character Testing
Passes valid rendering test:
- Input: (;;;;)
- Input: (!!!!)
- Input: ([][])
- Input: ({}{})
- Input: (,,,,)
- Input: (::::)
- Input: (....)
- Input: (^^^^)
- Input: (££££)
- Input: (++++)
- Input: (----)

Fails valid rendering test:
- Input: ('''')
- Input: (////)
- Input: (>>>>)
- Input: (<<<<)
- Input: (&&&&)

