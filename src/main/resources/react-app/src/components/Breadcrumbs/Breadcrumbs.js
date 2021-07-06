import { NavLink } from 'react-router-dom'
import './Breadcrumbs.scss'
import './BreadcrumbsMedia.scss'

export const Breadcrumbs = (key) => {
    return (
        <section key={key} id="breadcrumbs" className="breadcrumbs">
        <section className="wrapper">
            <nav className="breadcrumbs__nav">
                <ul>
                    <li className="breadcrumbs__tab"><NavLink to='/'>Home</NavLink></li>
                    <li className="breadcrumbs__tab"><NavLink to='/'>Accessories</NavLink></li>
                    <li className="breadcrumbs__tab breadcrumbs__tab--active"><NavLink to='/'>Beat Solo 2 on Ear Headphones - Black</NavLink></li>
                </ul>
            </nav>
        </section>
    </section>
    )
}