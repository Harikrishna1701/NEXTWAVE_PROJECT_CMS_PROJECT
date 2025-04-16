import React from 'react'
import './bottom.css'
import frame1 from './assets/frame1.png'
import frame2 from './assets/frame2.png'
import frame3 from './assets/frame3.png'
import frame4 from './assets/frame4.png'
import frame5 from './assets/frame5.png'
import frame6 from './assets/frame6.png'


const BottomContent = () => {
  return (
    <div className='bottom-container'>
      <div>
        <img  src={frame1} alt="frame1" className='frame1' />
      </div>
      <div>
        <img src={frame2} alt="frame2" className='frame2' />
      </div>
      <div>
        <img src={frame3} alt="frame3" className='frame3' />
      </div>
      <div>
        <img src={frame4} alt="frame4" className='frame4' />
      </div>
      <div>
        <img src={frame5} alt="frame5" className='frame5' />
      </div>
      <div>
        <img src={frame6} alt="frame6" className='frame6' />
      </div>
    </div>
  )
}

export default BottomContent