# ToDoMVC Testing Notes

Unavailable Frameworks:
- Humble + GopherJS (https://todomvc.com/examples/humble/)
- SomaJS (https://todomvc.com/examples/somajs/)

Framework missing styling:
- Aurelia (https://todomvc.com/examples/aurelia/)

## Special character testing:

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

## ToDo:
- Test accented characters render correctly