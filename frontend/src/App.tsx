import { createBrowserRouter, RouterProvider, createRoutesFromElements, Route } from 'react-router-dom'
import './App.css'
import Home from './pages/Home'
import Navbar from './components/Navbar'

function App() {
  const router = createBrowserRouter(
    createRoutesFromElements(
      <Route path='/' element={<Home />}>
      </Route>
    )
  )

  return (
    <>
      <Navbar />
      <RouterProvider router={router}></RouterProvider>
    </>
  )
}

export default App
