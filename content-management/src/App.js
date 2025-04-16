
import './App.css';
import BottomContent from './components/BottomContent';
import Content from './components/Content';
import NavBar from './components/NavBar';


function App() {
  return (
    <div className="App">
      <NavBar />
      <Content />
      <BottomContent />
    </div>
  );
}

export default App;
