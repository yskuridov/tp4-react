import './App.css';
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import HomePage from "./Components/HomePage";
import PageNotFound from "./Components/PageNotFound";
import Employee from "./Components/EmployeeComponents/Employee";
import Member from "./Components/MemberComponents/Member";

function App() {
  return (
   <div>
       <Router>
           <Routes>
               <Route path='*' element={<PageNotFound />} />
               <Route path='/' element={<HomePage />} />
               <Route path='/employee' element={<Employee />} />
               <Route path='/member' element={<Member />} />
           </Routes>
     </Router>
   </div>
  );
}

export default App;
