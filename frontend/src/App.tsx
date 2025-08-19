import { createBrowserRouter, RouterProvider, createRoutesFromElements, Route } from 'react-router-dom'
import './App.css'
import Home from './pages/Home'
import Layout from './pages/Layout'

function App() {
  const router = createBrowserRouter(
    createRoutesFromElements(
      <Route path='/' element={<Layout />}>
        <Route path='/' element={<Home />} />
      </Route>
    )
  )

  return (
    <>
      <RouterProvider router={router}></RouterProvider>
    </>
  )
}

export default App
