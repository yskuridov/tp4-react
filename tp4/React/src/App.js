import './App.css';
import {BrowserRouter as Router, Route, Routes} from "react-router-dom";
import HomePage from "./Components/HomePage";
import PageNotFound from "./Components/PageNotFound";
import Employee from "./Components/EmployeeComponents/Employee";
import Member from "./Components/MemberComponents/Member";
import AddBook from "./Components/EmployeeComponents/AddBook";
import AddCd from "./Components/EmployeeComponents/AddCd";
import AddDvd from "./Components/EmployeeComponents/AddDvd";
import AddMember from "./Components/EmployeeComponents/AddMember";
import Documents from "./Components/EmployeeComponents/Documents";


function App() {
  return (
   <div>
       <Router>
           <Routes>
               <Route path='*' element={<PageNotFound />} />
               <Route path='/' element={<HomePage />} />
               <Route path='/employee' element={<Employee />} />
               <Route path='/employee/addBook' element={<AddBook />} />
               <Route path='/employee/addCd' element={<AddCd />} />
               <Route path='/employee/addDvd' element={<AddDvd />} />
               <Route path='/employee/addMember' element={<AddMember />} />
               <Route path='/member' element={<Member />} />
           </Routes>
     </Router>
   </div>
  );
}

export default App;
