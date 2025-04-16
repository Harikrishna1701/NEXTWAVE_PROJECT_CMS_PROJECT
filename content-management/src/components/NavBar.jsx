import React from 'react'
import './navbar.css'

const NavBar = () => {
  return (
    <div className='navbar-container'>
        <div className='navbar'>
            <nav className='navbar-items'>
                <a href="/">About</a>
                <a href="/about">Services</a>
            </nav>
        </div>
    </div>
  )
}

export default NavBar