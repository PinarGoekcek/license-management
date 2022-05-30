
const NavButton = ({name, linkTo, icon}) => {
  return (
    <div>
        <a href="{linkTo}" alt="{name}"></a>{icon}
    </div>
  )
}

export default NavButton